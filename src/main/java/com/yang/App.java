package com.yang;

import com.yang.view.home.Home;
import com.yang.view.login.LoginView;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        try
        {
            //设置本属性将改变窗口边框样式定义
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }
        catch(Exception e)
        {
            //TODO exception
        }
        //登陆界面
        LoginView loginView = new LoginView();

        //修改密码界面
        /*Registeration registeration = new Registeration();*/

        //登陆主界面
        /*Home home = new Home();*/
    }
}
