import androidx.compose.material3.pulltorefresh.PullToRefreshState

fun test(state: PullToRefreshState) {
    println(state.progress)
    println(state.position)
    println(state.verticalOffset)
}
