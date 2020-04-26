package com.shgbit.ktexample.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import com.shgbit.ktexample.R
import com.shgbit.ktexample.api.RxRestServiceApi
import com.shgbit.ktexample.app.HobbyApplication
import com.shgbit.ktexample.base.BaseActivity
import com.shgbit.ktexample.network.NewworkScheduler
import com.shgbit.ktexample.network.RxRestClient
import com.shgbit.ktexample.util.CustomToast
import com.shgbit.ktexample.util.PLog
import com.shgbit.ktexample.util.SpUtil
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import kotlinx.android.synthetic.main.activity_login_layout.*

/**
 * @author xushun on  2020/3/29 13:08.
 * Email：shunplus@163.com
 * Des：
 */
class LoginActivity :BaseActivity() {
    private var cookie: String by SpUtil("Cookie", "")
    // 委托属性，Preference把取值和存值的操作代理给variable，我们对userId的赋值和取值最终是操作的Preference得setValue和getValue函数。
    //由于已经能够推断出variable的类型是String，所以这里的variable省去了类型。
    private var courtId by SpUtil("courtId", "")
    private var courtName by SpUtil("courtName", "")
    private var username by SpUtil("username", "")
    private var pasword by SpUtil("pasword", "")
    //完整写法如下：
    //private var variable: String by Preference("keyName", "10")

    lateinit var mContext:Context
    var courtIdv: String = ""
    var courtNamev: String = ""
    var paswordv: String = ""
    var usernamev: String = ""
    var isChecked:Boolean=true
    override fun getLayoutId(): Int {
      return R.layout.activity_login_layout
    }

    override fun initView() {
        mContext=this
        tv_court.setOnClickListener(onClickListener)
        login_btn.setOnClickListener(onClickListener)
        cb_remember_pwd.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                this@LoginActivity.isChecked =!isChecked
                if (!isChecked) {
                    pasword=""
                }
            }
        })


    }

    override fun initData() {
        isChecked=cb_remember_pwd.isChecked
        if (courtName.isNotBlank()){
            tv_court.setText(courtName)
        }
        if (username.isNotBlank()){
            et_username.setText(username)
        }

        if (pasword.isNotBlank()){
            et_password.setText(pasword)
        }
        if (courtId.isNotBlank()) {
            courtIdv = courtId
        }
    }

    private val onClickListener= View.OnClickListener {
            view->
        when(view.id){
            R.id.tv_court ->{
                /**
                 * 选择法院
                 */
         var intent=Intent(mContext, SelectCourtActivity::class.java)
              startActivityForResult(intent,0x11)
            }
            R.id.login_btn ->{
                Log.d(PLog.TAG, " start login")
                /**
                 * 登录
                 */
                paswordv=et_password.text.toString()
                usernamev=et_username.text.toString()
                courtNamev = tv_court.text.toString()
                if(courtIdv.isBlank()){
                CustomToast.showToastMultipleClicks("请选择法院")
                    return@OnClickListener
                }
                if(usernamev.isBlank()){
                CustomToast.showToastMultipleClicks("请输入用户名")
                    return@OnClickListener
                }
                if(paswordv.isBlank()){
                CustomToast.showToastMultipleClicks("请输入密码")
                    return@OnClickListener
                }

                /**
                 * 登录时清除Cookie
                 */
                cookie=""
                RxRestClient.instance.getService(RxRestServiceApi::class.java).login(usernamev,paswordv,courtIdv,"1212121212")
                    .compose(NewworkScheduler.compose())
                    .bindUntilEvent(this, ActivityEvent.DESTROY)
                    .subscribe(
                        {
                                t->
                            run {
                                Log.d(PLog.TAG, "  login sucess")
                                HobbyApplication.userId=t.data.user.id
                                courtId=courtIdv
                                username=usernamev
                                courtName=courtNamev
                                if(isChecked){
                                   pasword=paswordv
                                }else{
                                    pasword=""
                                }
                                var intentl=Intent(mContext, MainActivity::class.java)
                                startActivity(intentl)
                            }
                        },
                        {
                                e->Log.e(PLog.TAG," failure $e")
                            CustomToast.showToastMultipleClicks("登录失败")
                        }
                    )


            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d(PLog.TAG," onActivityResult")
        if (requestCode==0x11&&resultCode== Activity.RESULT_OK){
             courtIdv= data?.getStringExtra("courtId").toString()
            courtNamev=data?.getStringExtra("courtName").toString();
            tv_court.setText(courtNamev)
        }
    }
}