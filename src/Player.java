class Player{
	private long goldCoins;
	private String name;
	private int str,agi,dex,intl,vit,luck; //Atributos usados para calcular os outros
	private int baseHP,baseSP; //calculados a partir de vit e intl, respectivamente
	private int currentHP,currentSP; //HP e SP durante o combate
	private int level; //vamos fazer de 1 a 99? 
	private int exp; //experiência atual
	private int nextLevel; //exp necessaria pra subir para o proximo level

	public Player(String name){
		this.name = name;
		this.level = 1;
		this.goldCoins = 0L;
		str = 1;
		agi = 1;
		dex = 1;
		intl = 1;
		vit = 1;
		luck = 1;
		calculateHpSp(); //funcao que calcula hp e sp maximos;
		currentHP = baseHP;
		currentSP = baseSP;
	}
	public void calculateHpSp(){
		this.baseHP = 50+10*vit;
		this.baseSP = (int)(10+0.25*intl);
	} 
	public void setStr(int str){ this.str = str; }
	public void setAgi(int agi){ this.agi = agi; }
	public void setDex(int dex){ this.dex = dex; }
	public void setIntl(int intl){ this.intl = intl; }
	public void setVit(int vit){ this.vit = vit; }
	public void setLuck(int luck){ this.luck = luck; }
	
	public int getStr(){ return str; }
	public int getAgi(){ return agi;}
	public int getDex(){ return dex; }
	public int getIntl(){ return intl; }
	public int getVit(){ return vit; }
	public int getLuck(){ return luck; }//SHE'S UP ALL NIGHT TO getLucky
	public int getLevel(){ return level; }
	
	public void levelUp(){
		level++;
		calculateHpSp();
	}
}
