from PIL import Image
import os

source_path = '/home/knp/.gemini/antigravity/brain/f64f724a-d67c-44df-87e3-0f86b9da0eed/bingeboard_logo_v2_1772785990780.png'
dest_png = '/home/knp/Music/Coding/Tvshowapp/BingeBoard/BingeBoard_Logo_Transparent.png'

# Load image
img = Image.open(source_path).convert("RGBA")

# Create a transparent image matching the original size
transparent_img = Image.new("RGBA", img.size, (0, 0, 0, 0))

# We'll do a simple luma key extraction.
# Since the background is white, pixels closer to white become more transparent.
# To protect the bright colors of the logo itself, we only make pure white transparent.
# Actually, flood fill from the corner (0,0) is better to find the background mask.
from PIL import ImageDraw

# Create mask using floodfill
mask = Image.new('L', img.size, 255) # white means keep
ImageDraw.floodfill(mask, (0, 0), 0, thresh=10) # fill background with black

# Apply mask as alpha
img.putalpha(mask)

# Save the exact cropped transparent PNG
img.save(dest_png, "PNG")

# Convert the PNG to base64 and embed in SVG to provide an exact SVG file
import base64
with open(dest_png, "rb") as image_file:
    encoded_string = base64.b64encode(image_file.read()).decode()

svg_content = f"""<svg viewBox="0 0 {img.width} {img.height}" width="{img.width}" height="{img.height}" xmlns="http://www.w3.org/2000/svg">
  <image href="data:image/png;base64,{encoded_string}" width="{img.width}" height="{img.height}" />
</svg>"""

with open('/home/knp/Music/Coding/Tvshowapp/BingeBoard/BingeBoard_Logo.svg', 'w') as f:
    f.write(svg_content)

print(f"Created SVG and Transparent PNG. Image size: {img.size}")
