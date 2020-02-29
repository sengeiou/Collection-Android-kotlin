package com.youngmanster.collection_kotlin.recyclerview

import android.content.Context
import com.youngmanster.collection_kotlin.R

/**
 * Created by yangy
 *2020-02-28
 *Describe:
 */

class LoadingTextConfig private constructor(context: Context) {
    private var collectionPullRefreshText: String? = null
    private var collection_release_refresh: String? = null
    private var collection_refresh_done: String? = null
    private var collection_refreshing: String? = null
    private var collectionLastRefreshTime: String? = null
    private var collection_loading_more: String? = null
    private var collection_no_more_data: String? = null

    init {
        collectionPullRefreshText = context.getString(R.string.collection_pull_to_refresh)
        collection_release_refresh = context.getString(R.string.collection_release_refresh)
        collection_refresh_done = context.getString(R.string.collection_refresh_done)
        collection_refreshing = context.getString(R.string.collection_refreshing)
        collectionLastRefreshTime = context.getString(R.string.collection_last_refresh_time)
        collection_loading_more = context.getString(R.string.collection_loading_more)
        collection_no_more_data = context.getString(R.string.collection_no_more_data)
    }

    fun setCollectionRefreshDone(text: String): LoadingTextConfig {
        collection_refresh_done = text
        return this
    }

    fun getCollectionRefreshDone(): String {
        return collection_refresh_done!!
    }

    fun setCollectionRefreshing(text: String): LoadingTextConfig {
        collection_refreshing = text
        return this
    }

    fun getCollectionRefreshing(): String {
        return collection_refreshing!!
    }

    fun setCollectionLastRefreshTimeTip(text: String): LoadingTextConfig {
        collectionLastRefreshTime = text
        return this
    }

    fun getCollectionLastRefreshTimeTip():String{
        return collectionLastRefreshTime!!
    }

    fun setCollectionLoadingMore(text: String): LoadingTextConfig {
        collection_loading_more = text
        return this
    }

    fun getCollectionLoadingMore(): String? {
        return collection_loading_more
    }

    fun setCollectionNoMoreData(text: String): LoadingTextConfig {
        collection_no_more_data = text
        return this
    }

    fun getCollectionNoMoreData(): String{
        return collection_no_more_data!!
    }

    fun setCollectionPullDownRefreshText(text: String): LoadingTextConfig {
        collectionPullRefreshText = text
        return this
    }

    fun getCollectionPullDownRefreshText():String{
        return collectionPullRefreshText!!
    }

    fun setCollectionPullReleaseText(text: String): LoadingTextConfig {
        collection_release_refresh = text
        return this
    }

    fun getCollectionPullReleaseText(): String? {
        return collection_release_refresh
    }

    companion object {

        private var loadingTextConfig: LoadingTextConfig? = null

        fun getInstance(context: Context): LoadingTextConfig {
            if (loadingTextConfig == null) {
                synchronized(LoadingTextConfig::class.java) {
                    if (loadingTextConfig == null) {
                        loadingTextConfig = LoadingTextConfig(context)
                    }
                }
            }

            return loadingTextConfig!!
        }
    }

}