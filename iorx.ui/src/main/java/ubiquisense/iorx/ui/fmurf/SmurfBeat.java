package ubiquisense.iorx.ui.fmurf;

public class SmurfBeat extends Thread {
	int bpm = 80;
	public void setBPM(int _bpm)
	{
		bpm = _bpm;
	}
	public int getBPM()
	{
		return bpm;
	}
	public int bang()
	{
		return 0;
	}
	
	/*
	 * 
	 * 	int bpm;
		
	//--------------------------
	SmurfBeat(){
		lastCount = 1;
		count = 0;
		bpm = 60;
	}
	
	void start(){
		startThread(true, false);   // blocking, verbose
	}
	
	void stop(){
		stopThread();
	}
	
	//--------------------------
	void threadedFunction(){
		while( isThreadRunning() != 0 ){
			if( lock() ){
				count++;
				if(count >= LONG_MAX) count = 0;
				unlock();
				ofSleepMillis(60000 / bpm);
			}
		}
	}
	
	//--------------------------
	int bang(){
		if( lock() ){
			if (lastCount != count) {
				lastCount = count;
				unlock();
				return lastCount;
			} 
			unlock();
		} else {
			cout << "can't lock!\neither an error\nor the thread has stopped";
		}
		return -1;
	}
	
	void setBPM(int _bpm) {
		bpm = _bpm;
	}
	
	int getBPM() {
		return bpm;
	}
	 */
}
