package com.hxc.supreme.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hxc.supreme.R;
import com.hxc.supreme.utils.XToast;


/**
 * created by huxc  on 2017/9/28.
 * func：  Synchronize
 * email: hxc242313@qq.com
 */

public class SynchronizeTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synchronize_test);
    }

    @Override
    protected void onResume() {
        super.onResume();
        noSyncTest();
//        MethodSyncTest();
//        StaticMethodSyncTest();
    }

    class NoSyncTest {
        public void method1() {
            Log.i("sync", "method 1 start");
            try {
                Log.i("sync", "method 1 execute");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Log.i("sync", "method 1 end");
        }

        public void method2() {
            Log.i("sync", "method 2 start");
            try {
                Log.i("sync", "method 2 execute");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Log.i("sync", "method 2 end");
        }
    }

    private void noSyncTest() {
        final NoSyncTest test = new NoSyncTest();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.method1();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.method2();
            }
        });

        thread1.start();
        thread2.start();
    }

    class MethodSyncTest {
        public synchronized void method1() {
            Log.i("sync", "method 1 start");
            try {
                Log.i("sync", "method 1 execute");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Log.i("sync", "method 1 end");
        }

        public synchronized void method2() {
            Log.i("sync", "method 2 start");
            try {
                Log.i("sync", "method 2 execute");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Log.i("sync", "method 2 end");
        }
    }

    private void MethodSyncTest() {
        final MethodSyncTest test = new MethodSyncTest();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.method1();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.method2();
            }
        });

        thread1.start();
        thread2.start();
    }

    static class StaticMethodSyncTest {
        public static synchronized void method1() {
            Log.i("sync", "method 1 start");
            try {
                Log.i("sync", "method 1 execute");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Log.i("sync", "method 1 end");
        }

        public static synchronized void method2() {
            Log.i("sync", "method 2 start");
            try {
                Log.i("sync", "method 2 execute");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Log.i("sync", "method 2 end");
        }
        public static synchronized void method3() {
            Log.i("sync", "method 3 start");
            try {
                Log.i("sync", "method 3 execute");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Log.i("sync", "method 3 end");
        }
    }

    private void StaticMethodSyncTest() {
        final StaticMethodSyncTest test1 = new StaticMethodSyncTest();
        final StaticMethodSyncTest test2 = new StaticMethodSyncTest();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test1.method1();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test2.method2();
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                StaticMethodSyncTest.method3();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
