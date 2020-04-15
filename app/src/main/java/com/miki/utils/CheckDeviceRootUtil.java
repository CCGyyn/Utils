package com.miki.utils;

import android.util.Log;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author：cai_gp on 2019/6/25 14:09
 * 检查是否具有root权限
 */
public class CheckDeviceRootUtil {
    /**
     * 判断机器Android是否已经root，即是否获取root权限
     */
    public static boolean checkDeviceRoot() {
        boolean resualt = false;
        // 通过执行测试命令来检测
        int ret = execRootCmdSilent("echo test");
        if (ret != -1) {
            Log.i("checkDeviceRoot", "this Device have root!");
            resualt = true;
        } else {
            resualt = false;
            Log.i("checkDeviceRoot", "this Device not root!");
        }
        return resualt;
    }

    /**
     * 执行命令但不关注结果输出
     */
    public static int execRootCmdSilent(String cmd) {
        int result = -1;
        DataOutputStream dos = null;
        try {
            Process p = Runtime.getRuntime().exec("su");
            dos = new DataOutputStream(p.getOutputStream());
            dos.writeBytes(cmd + "\n");
            dos.flush();
            dos.writeBytes("exit\n");
            dos.flush();
            p.waitFor();
            result = p.exitValue();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
