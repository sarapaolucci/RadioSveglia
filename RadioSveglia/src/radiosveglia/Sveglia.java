/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radiosveglia;
import java.util.Random;
import javax.sound.sampled.*;

/**
 *
 * @author sarap
 */
public class Sveglia {
    private int volume, minuti, ore, giorno, mese, anno, hSveglia, mSveglia;
    private String ora, sveglia, radio, stazioneRadio;
    private double frequenza;
    private FloatControl volumeCont;
    Clip clip;
    
    Random random = new Random();
    
    public void aumentaVolume(){
        if(volume != 10){
            volume++;
        }
        aggiornaVolume();
    }
    
    public void diminuisciVolume(){
        if(volume > 0){
            volume--;
        }
        aggiornaVolume();
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
        String [] tempos = sveglia.split(":");
        this.mSveglia = Integer.parseInt(tempos[1]);
        this.hSveglia = Integer.parseInt(tempos[0]);
    }
    
    public void setOra(String o){
        this.ora = o;
        String [] tempo = ora.split(":");
        this.minuti = Integer.parseInt(tempo[1]);
        this.ore = Integer.parseInt(tempo[0]);
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
    
    public double getFrequenza(){
        return this.frequenza;
    }
    
    public String getStazione(){
        return this.stazioneRadio;
    }
    
    public void aggiornaVolume(){
        if(volumeCont != null){
            float min = volumeCont.getMinimum();
            float max = volumeCont.getMaximum();
            float range = max - min;
            float newVolume = min+(range*(volume / 10.0f));
            
            volumeCont.setValue(newVolume);
        }
        
    }
    
    public void aggiornaData(){
        giorno++;
        if(mese == 2 && anno % 4 == 0 && giorno == 30){
            mese++;
            giorno = 1;
        }
        else if(mese == 2 && giorno == 29){
            mese++;
            giorno = 1;
        }
        else if(mese == 11 || mese == 4 || mese == 6 || mese == 9){
            if(giorno == 31){
                mese++;
                giorno = 1;
            }
        }
        else{
            if(giorno == 32){
                mese++;
                giorno = 1;
                if(mese == 12){
                    mese = 1;
                    anno++;
                    giorno = 1;
                }
            }
        }
    }
    
    public void rinvia(){ 
        this.mSveglia += 5;
        if(mSveglia >= 60){
            mSveglia = mSveglia % 60;
            hSveglia++;
            if(hSveglia > 23){
                hSveglia = 0;
            }
        }
        this.sveglia = contZero(hSveglia) + ":" + contZero(mSveglia);
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
        this.ora = contZero(ore) + ":" + contZero(minuti);
        this.hSveglia = random.nextInt(0,24);
        this.mSveglia = random.nextInt(0,60);
        this.sveglia = contZero(hSveglia) + ":" + contZero(mSveglia);
    }
    
    public String contZero (int z){
        if(z < 10){
            return "0" + String.valueOf(z);
        }
        return String.valueOf(z);
    }
    
    public void cambiaStazione(String stazione){
        this.radio = stazione;
        switch (stazione) {
            case "RTL 102.5" -> {
                this.frequenza = 24.3;
                this.stazioneRadio = "RTL 102.5";
            }
            case "Radio 105" -> {
                this.frequenza = 26.2;
                this.stazioneRadio = "Radio 105";
            }
            case "Radio 24" -> {
                this.frequenza = 24.0;
                this.stazioneRadio = "Radio 24";
            }
            default -> {
                this.frequenza = 12.3;
                this.stazioneRadio = "Radio m2o";
            }
        }
    }
    
    public void riproduciWav(String nomeFile) {
    try {
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResource("/suoni/" + nomeFile));
        this.clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    
    
    public void interrompiWav() {
        if (this.clip != null && this.clip.isRunning()) {
           clip.stop();             
           clip.setFramePosition(0); 
        }
    }
    
    public void suonaSveglia(String stazione){
        switch (stazione) {
            case "RTL 102.5" -> riproduciWav("nickyminaj.wav");
            case "Radio 105" -> riproduciWav("spann.wav");
            case "Radio 24" -> riproduciWav("heartless.wav");
            default -> riproduciWav("pokerface.wav");
        }
    }
    
}
