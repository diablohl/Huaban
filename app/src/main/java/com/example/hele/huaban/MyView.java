package com.example.hele.huaban;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

/**
 * Created by hele on 2017/3/14.
 */

public class MyView extends SurfaceView implements Callback,OnTouchListener{


    public static Paint paint=new Paint(); //画笔对象
    private Path path=new Path();

    //构造方法
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this); //添加回调函数

        //初始化画笔颜色,粗细，类型
        paint.setColor(Color.RED);
        //paint.setTextSize(10);
        paint.setStrokeWidth(18);
        paint.setStyle(Paint.Style.STROKE);

        setOnTouchListener(this);

    }
    //绘制方法
    public  void  draw(){
        Canvas canvas=getHolder().lockCanvas(); //锁定画布

        //初始化画布
        canvas.drawColor(Color.WHITE);
        canvas.drawPath(path,paint);

        getHolder().unlockCanvasAndPost(canvas); //解锁画布
    }

    //清理画布方法
    public void clear(){
        path.reset();
        draw();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
            //画笔落下绘制
            case MotionEvent.ACTION_DOWN:
                path.moveTo(event.getX(),event.getY());
                draw();
                break;
            //画笔移动绘制
            case  MotionEvent.ACTION_MOVE:
                path.lineTo(event.getX(),event.getY());
                draw();
                break;
        }
        return true;
    }
}
