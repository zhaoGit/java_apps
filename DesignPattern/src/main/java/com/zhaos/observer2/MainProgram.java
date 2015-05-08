package com.zhaos.observer2;

public class MainProgram{
	public  static  void  App(String[] args ){
		Point  mp = new  Point( 3,5);
		PointListener  plistener1 = new  PointListener(){
				public void  pointMove( PointEventObject  e )	{
					System.out.println("第一个事件监听者" );
				}
		};

		PointListener  plistener2 = new  PointListener(){
			public void  pointMove( PointEventObject  e ){
				System.out.println("第二个事件监听者");
			}
		};

		PointListener  plistener3 = new  PointListener(){

				public void  pointMove( PointEventObject  e )	{
						System.out.println("第三个事件监听者");
					}
			};

			mp.addEventListener( plistener1 );
			mp.addEventListener( plistener2 );
			mp.addEventListener( plistener3 );

			mp.moveTo(10,20);
	}
}
