package com.itheima.player.ui.fragment

import android.view.View
import com.itheima.player.R
import com.itheima.player.adapter.MvPagerAdapter
import com.itheima.player.base.BaseFragment
import com.itheima.player.model.bean.MvAreaBean
import com.itheima.player.presenter.impl.MvPresenterImpl
import com.itheima.player.view.MvView
import kotlinx.android.synthetic.main.fragment_mv.*


/**
 * ClassName:HomeFragment
 * Description:
 */
class MvFragment: BaseFragment(), MvView {
    override fun onError(msg: String?) {
        myToast("加载区域数据失败")
    }

    override fun onSuccess(result: List<MvAreaBean>) {
        //在fragment中管理fragment需要用childFragmentManager
        val adapter = MvPagerAdapter(context,result,childFragmentManager)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }

    val presenter  by lazy { MvPresenterImpl(this) }
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_mv,null)
    }

    override fun initListener() {

    }

    override fun initData() {
        //加载区域数据
        presenter.loadDatas()
    }
}