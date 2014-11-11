package rpg.system;

public class Mob {
	private int hp,str,agi,dex,vit,luck,intl;
	
	public Mob(int h,int s, int a, int d, int v, int l, int i){
		hp = h;
		str = s;
		agi = a;
		dex = d;
		vit = v;
		luck = l;
		intl = i;
	}
	public int getAgi(){
		return agi;
	}
	public int getLuck(){
		return luck;
	}
	public int getHp(){
		return hp;
	}
	public int getVit(){
		return vit;
	}
	public int getStr(){
		return str;
	}
	public void setHp(int newHp){
		hp = newHp;
		if(hp < 0){
			hp = 0;
		}
	}
	public void damage(int d){
		setHp(this.hp - d);
	}
	public String toString(){
		return "HP: "+hp+" STR: "+str+" AGI: "+agi+" DEX: "+dex+" VIT: "+vit
				+" LUCK: "+luck+" INTL: "+intl;
	}

}
