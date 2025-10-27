/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radiosveglia;

/**
 *
 * @author sarap
 */
public class Sveglia {
    private int volume;
    private String ora, giorno, mese, anno, sveglia;
    
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
    
    public void setGiorno(String g){
        this.giorno = g;
    }
    
    public void setMese(String m){
        this.mese = m;
    }
    
    public void setAnno(String a){
        this.anno = a;
    }
    
    public String getOra(){
        return this.ora;
    }
    
    public String getGiorno(){
        return this.giorno;
    }
    
    public String getMese(){
        return this.mese;
    }
    
    public String getAnno(){
        return this.anno;
    }
}
