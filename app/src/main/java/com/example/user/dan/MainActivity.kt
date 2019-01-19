package com.example.user.dan

import android.content.pm.ActivityInfo
import android.hardware.SensorEventListener
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceHolder
import android.hardware.SensorEvent
import android.hardware.Sensor
import android.hardware.SensorManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SensorEventListener, SurfaceHolder.Callback {

    private var surfaceWidth:Int=0
    private var surfaceHeight:Int=0

    private val radius=20.0f
    private val coef=1000.0f
    private var ballX:Float=0f
    private var ballY:Float=0f
    private var vx:Float=0f
    private var vy:Float=0f
    private var time:Long=0L

    private var x1:Float=0f
    private var y1:Float=0f
    private var vx1:Float=(Math.random()*10+10).toFloat()
    private var vy1:Float=(Math.random()*5+6).toFloat()
    private val r1:Float=25.0f
    private var x2:Float=0f
    private var y2:Float=0f
    private var vx2:Float=(Math.random()*10-20).toFloat()
    private var vy2:Float=(Math.random()*20-30).toFloat()
    private val r2:Float=30.0f
    private var x3:Float=0f
    private var y3:Float=0f
    private var vx3:Float=(Math.random()*40-20).toFloat()
    private var vy3:Float=(Math.random()*40-20).toFloat()
    private val r3:Float=28.0f
    private var x4:Float=0f
    private var y4:Float=0f
    private var vx4:Float=(Math.random()*40-20).toFloat()
    private var vy4:Float=(Math.random()*40-20).toFloat()
    private val r4:Float=20.0f

    private var cx1:Float=0f
    private var cy1:Float=0f
    private val cr1:Float=13f
    private var cx2:Float=0f
    private var cy2:Float=0f
    private val cr2:Float=13f
    private var cx3:Float=0f
    private var cy3:Float=0f
    private val cr3:Float=13f
    private var count:Int=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_main)
        val holder=surfaceView.holder
        holder.addCallback(this)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        if(event==null)return
        if(time==0L)time=System.currentTimeMillis()
        if(event.sensor.type==Sensor.TYPE_ACCELEROMETER){
            val x= -event.values[0]
            val y= event.values[1]
            var t=(System.currentTimeMillis()-time).toFloat()
            time =System.currentTimeMillis()
            t /= 1000.0f
            val dx=vx*t+x*t*t/2.0f
            val dy=vy*t+y*t*t/2.0f
            ballX+=dx*coef
            ballY+=dy*coef
            vx+=x*t
            vy+=y*t
            if (ballX-radius<0&&vx<0){
                vx= -vx/1.5f
                ballX=radius
            }
            else if(ballX+radius>surfaceWidth&&vx>0){
                vx= -vx/1.5f
                ballX=surfaceWidth-radius
            }
            if(ballY-radius<0&&vy<0){
                vy= -vy/1.5f
                ballY=radius
            }
            else if(ballY+radius>surfaceHeight&&vy>0){
                vy= -vy/1.5f
                ballY=surfaceHeight-radius
            }
            x1+=vx1
            y1+=vy1
            if (x1-r1<0){
                vx1= -vx1
                x1=r1
            }
            else if(x1+r1>surfaceWidth){
                vx1= -vx1
                x1=surfaceWidth-r1
            }
            if(y1-r1<0){
                vy1= -vy1
                y1=r1
            }
            else if(y1+r1>surfaceHeight){
                vy1= -vy1
                y1=surfaceHeight-r1
            }
            x2+=vx2
            y2+=vy2
            if (x2-r2<0){
                vx2= -vx2
                x2=r2
            }
            else if(x2+r2>surfaceWidth){
                vx2= -vx2
                x2=surfaceWidth-r2
            }
            if(y2-r2<0){
                vy2= -vy2
                y2=r2
            }
            else if(y2+r2>surfaceHeight){
                vy2= -vy2
                y2=surfaceHeight-r2
            }
            x3+=vx3
            y3+=vy3
            if (x3-r3<0){
                vx3= -vx3
                x3=r3
            }
            else if(x3+r3>surfaceWidth){
                vx3= -vx3
                x3=surfaceWidth-r3
            }
            if(y3-r3<0){
                vy3= -vy3
                y3=r3
            }
            else if(y3+r3>surfaceHeight){
                vy3= -vy3
                y3=surfaceHeight-r3
            }
            x4+=vx4
            y4+=vy4
            if (x4-r4<0){
                vx4= -vx4
                x4=r4
            }
            else if(x4+r4>surfaceWidth){
                vx4= -vx4
                x4=surfaceWidth-r4
            }
            if(y4-r4<0){
                vy4= -vy4
                y4=r4
            }
            else if(y4+r4>surfaceHeight){
                vy4= -vy4
                y4=surfaceHeight-r4
            }

            if((ballX-cx1)*(ballX-cx1)+(ballY-cy1)*(ballY-cy1)<(radius+cr1)*(radius+cr1)){
                cx1=-20f
                cy1=-20f
                count+=1
                if(count==3){clear()}
            }
            else if((ballX-cx2)*(ballX-cx2)+(ballY-cy2)*(ballY-cy2)<(radius+cr2)*(radius+cr2)){
                cx2=-20f
                cy2=-20f
                count+=1
                if(count==3){clear()}
            }
            else if((ballX-cx3)*(ballX-cx3)+(ballY-cy3)*(ballY-cy3)<(radius+cr3)*(radius+cr3)){
                cx3=-20f
                cy3=-20f
                count+=1
                if(count==3){clear()}
            }
            if((ballX-x1)*(ballX-x1)+(ballY-y1)*(ballY-y1)<(radius+r1)*(radius+r1)){gameOver()}
            else if((ballX-x2)*(ballX-x2)+(ballY-y2)*(ballY-y2)<(radius+r2)*(radius+r2)){gameOver()}
            else if((ballX-x3)*(ballX-x3)+(ballY-y3)*(ballY-y3)<(radius+r3)*(radius+r3)){gameOver()}
            else if((ballX-x4)*(ballX-x4)+(ballY-y4)*(ballY-y4)<(radius+r4)*(radius+r4)){gameOver()}
            drawCanvas()
        }
    }

    override fun surfaceCreated(holder: SurfaceHolder?){
        val sensorManager=getSystemService(Context.SENSOR_SERVICE)as SensorManager
        val accSensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        sensorManager.registerListener(this,accSensor,SensorManager.SENSOR_DELAY_GAME)
    }

    override fun surfaceChanged(holder:SurfaceHolder?,format:Int,width:Int,height:Int){
        surfaceWidth=width
        surfaceHeight=height
        ballX=(width/2).toFloat()
        ballY=(height/3*2).toFloat()
        x1=(width/2+Math.random()*100-50).toFloat()
        y1=(height/3+Math.random()*100-50).toFloat()
        x2=(width/2+Math.random()*100-50).toFloat()
        y2=(height/2+Math.random()*100-50).toFloat()
        x3=(width/3+Math.random()*100-50).toFloat()
        y3=(height/4+Math.random()*100-50).toFloat()
        x4=(width/7*2+Math.random()*100-50).toFloat()
        y4=(height/5+Math.random()*100-50).toFloat()
        cx1=(Math.random()*width*3/4.0+150).toFloat()
        cy1=(Math.random()*height/4.0+50).toFloat()
        cx2=(Math.random()*width*3/4.0+150).toFloat()
        cy2=(Math.random()*height*3/5.0+400).toFloat()
        cx3=(Math.random()*width*3/4.0+150).toFloat()
        cy3=(Math.random()*height*2/5.0+1000).toFloat()
    }

    override fun surfaceDestroyed(holder:SurfaceHolder?){
        val sensorManager=getSystemService(Context.SENSOR_SERVICE)as SensorManager
        sensorManager.unregisterListener(this)
    }

    private fun drawCanvas() {
        val canvas = surfaceView.holder.lockCanvas()
        canvas.drawColor(Color.BLACK)
        canvas.drawCircle(ballX, ballY, radius, Paint().apply { color = Color.GREEN })
        canvas.drawCircle(x1, y1, r1, Paint().apply { color = Color.RED })
        canvas.drawCircle(x2,y2,r2,Paint().apply { color=Color.RED })
        canvas.drawCircle(x3,y3,r3,Paint().apply { color=Color.RED })
        canvas.drawCircle(x4,y4,r4,Paint().apply { color=Color.RED })
        canvas.drawCircle(cx1,cy1,cr1,Paint().apply { color=Color.YELLOW })
        canvas.drawCircle(cx2,cy2,cr2,Paint().apply { color=Color.YELLOW })
        canvas.drawCircle(cx3,cy3,cr3,Paint().apply { color=Color.YELLOW } )
        surfaceView.holder.unlockCanvasAndPost(canvas)
    }

    private fun gameOver(){
        val intent = Intent(this,Gameover::class.java)
        startActivity(intent)
    }

    private fun clear(){
        val intent =Intent(this,Clear::class.java)
        startActivity(intent)
    }
}