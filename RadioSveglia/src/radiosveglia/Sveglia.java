/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radiosveglia;
import java.util.Random;
/**
 *
 * @author sarap
 */
public class Sveglia {
    private int volume, minuti, ore, giorno, mese, anno, hSveglia, mSveglia;
    private String ora, sveglia;
    
    Random random = new Random();
    
    public void aumentaVolume(){
        if(volume != 10){
            volume++;
        }
    }
    
    public void diminuisciVolume(){
        if(volume > 0){
            volume--;
        }
    }
    
    public void setVolume(int v){
        this.volume = v;
    }
    
    public int getVolume(){
        return this.volume;
    }
    
    public String getSveglia(){
        return this.sveglia;
    }
    
    public void setSveglia(String s){
        this.sveglia = s;
    }
    
    public void setOra(String o){
        this.ora = o;
    }
    
    public void setGiorno(int g){
        this.giorno = g;
    }
    
    public void setMese(int m){
        this.mese = m;
    }
    
    public void setAnno(int a){
        this.anno = a;
    }
    
    public String getOra(){
        return this.ora;
    }
    
    public int getGiorno(){
        return this.giorno;
    }
    
    public int getMese(){
        return this.mese;
    }
    
    public int getAnno(){
        return this.anno;
    }
    
    public void impostaOra(){
        String [] tempo = ora.split(":");
        this.minuti = Integer.parseInt(tempo[1]);
        this.ore = Integer.parseInt(tempo[0]);
    }

    public void impostaRandomicamente(){
        this.anno = random.nextInt(2000,2027);
        this.mese = random.nextInt(1,13);
        if(mese == 2){
            if(anno % 4 == 0){
                this.giorno = random.nextInt(1,30);
            }
            else{
                this.giorno = random.nextInt(1,29);
            }
        }
        if(mese == 11 || mese == 4 || mese == 6 || mese == 9){
            this.giorno = random.nextInt(1,31);
        }
        else{
            this.giorno = random.nextInt(1,32);
        }
        this.ore = random.nextInt(0,24);
        this.minuti = random.nextInt(0,60);
        this.ora = controllaZero(ore) + ":" + controllaZero(minuti);
        this.hSveglia = random.nextInt(0,24);
        this.mSveglia = random.nextInt(0,60);
        this.sveglia = controllaZero(hSveglia) + ":" + controllaZero(mSveglia);
    }

    private String controllaZero (int z){
        if(z < 10){
            return "0" + String.valueOf(z);
        }
        return String.valueOf(z);
    }
    
    public String contZero (int z){
        if(z < 10){
            return "0" + String.valueOf(z);
        }
        return String.valueOf(z);
    }
    
}
