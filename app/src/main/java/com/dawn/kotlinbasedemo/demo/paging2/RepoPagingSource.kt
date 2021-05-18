package com.dawn.kotlinbasedemo.demo.paging2

//class RepoPagingSource() : PagingSource<Int, Repo>() {

//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Repo> {
//        return try {
//            val page = params.key ?: 1
//            val pageSize = params.loadSize
////            val repoResponse = gitHubService.searchRepos(page, pageSize)
//            val repoItems = repoResponse.items
//            val prevKey = if (page > 1) page - 1 else null
//            val nextKey = if (repoItems.isNotEmpty()) page + 1 else null
//            LoadResult.Page(repoItems, prevKey, nextKey)
//        } catch (e: Exception) {
//            LoadResult.Error(e)
//        }
//    }
//
//    override fun getRefreshKey(state: PagingState<Int, Repo>): Int? = null

//}

