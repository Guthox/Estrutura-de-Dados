public class No{

	private int info;
	private No proximo;

	public No (int info){
		setInfo(info);
		setProximo(null);
	}

	public void setInfo(int info){
		this.info = info;
	}

	public void setProximo(No proximo){
		this.proximo = proximo;
	}

	public int getInfo(){
		return info;
	}

	public No getProximo(){
		return proximo;
	}

}
