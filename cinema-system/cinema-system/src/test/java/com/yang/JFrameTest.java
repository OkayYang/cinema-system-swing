package com.yang;

import com.yang.view.login.ForgetPassWord;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.junit.Test;

public class JFrameTest {
    @Test
    public void jTest(){
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

    }
}
