package ubiquisense.iorx.cm;

public interface  RunnableWithResult<T> {
	void run();
	int getStatus();
	void setStatus(int value);
	T getResult();
	void setResult(T value);
	
	public abstract class Impl<X> implements RunnableWithResult<X>
	{
		X result;
		int status;

		@Override
		public int getStatus() {
			return status;
		}

		@Override
		public void setStatus(int value) {
			status = value;
		}

		@Override
		public void setResult(X value) {
			result = value;
		}

		@Override
		public X getResult() {
			return result;
		}
		
	}
}