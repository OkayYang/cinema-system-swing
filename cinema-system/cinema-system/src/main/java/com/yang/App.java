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
        /*LoginView loginView = new LoginView();*/
        /*Registeration registeration = new Registeration();*/

        Home home = new Home();



    }
}
