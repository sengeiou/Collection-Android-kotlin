package com.youngmanster.collectionkotlin.fragment.mvp

import androidx.recyclerview.widget.LinearLayoutManager
import com.youngmanster.collection_kotlin.base.stateview.StateView
import com.youngmanster.collection_kotlin.utils.ToastUtils
import com.youngmanster.collectionkotlin.R
import com.youngmanster.collectionkotlin.adapter.mvp.WeChatFeaturedAdapter
import com.youngmanster.collectionkotlin.base.BaseFragment
import com.youngmanster.collectionkotlin.bean.WeChatNews
import com.youngmanster.collectionkotlin.mvp.contract.WeChatChinaNewsContract
import com.youngmanster.collectionkotlin.mvp.presenter.WeChatChinaNewsDefinitionPresenter
import kotlinx.android.synthetic.main.fragment_wechat_news.*
import kotlinx.android.synthetic.main.layout_state.*
import java.util.ArrayList

/**
 * Created by yangy
 *2020-02-23
 *Describe:
 */

class FragmentChinaNewsDefinition :BaseFragment<WeChatChinaNewsDefinitionPresenter>(),
    WeChatChinaNewsContract.View{

    private val PAGE_SIZE = 15
    private var pageSize = 1

    private val mDatas = ArrayList<WeChatNews>()
    private var weChatFeaturedAdapter: WeChatFeaturedAdapter? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_wechat_news
    }

    override fun init() {
        state_view.showViewByState(StateView.STATE_LOADING)
        state_view.setOnDisConnectViewListener(object : StateView.OnDisConnectListener {
            override fun onDisConnectViewClick() {
                requestData()
            }

        })

        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        refreshRv.layoutManager = linearLayoutManager
    }

    override fun requestData() {
        (mPresenter as WeChatChinaNewsDefinitionPresenter).requestChinaNews(activity!!,pageSize, PAGE_SIZE)
    }

    override fun refreshUI(newsList: List<WeChatNews>?) {
        if (newsList != null) {
            if (pageSize == 1) {
                mDatas.clear()
                mDatas.addAll(newsList)
            } else {
                mDatas.addAll(newsList)
            }

        }

        if (weChatFeaturedAdapter == null) {
            if (mDatas.size == 0) {
                state_view.showViewByState(StateView.STATE_EMPTY)
            } else {
                state_view.showViewByState(StateView.STATE_NO_DATA)
            }
            weChatFeaturedAdapter = WeChatFeaturedAdapter(activity,R.layout.item_wechat_featured, mDatas, refreshRv)
            refreshRv.adapter = weChatFeaturedAdapter
        }
    }

    override fun onError(errorMsg: String) {
        ToastUtils.showToast(activity,errorMsg)
        if(mDatas.size == 0){
            state_view.showViewByState(StateView.STATE_DISCONNECT)
        }
    }

}