/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmark;

/**
 *
 * @author tranp
 */
public class Student {
   private String name;
   private double practical;
   private double progress;
   private double mid;
   private double avg;
   public Student(){
       
   }

    public Student(String name, double practical, double progress, double mid, double avg) {
        this.name = name;
        this.practical = practical;
        this.progress = progress;
        this.mid = mid;
        this.avg = avg;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPractical() {
        return practical;
    }

    public void setPractical(double practical) {
        this.practical = practical;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public double getMid() {
        return mid;
    }

    public void setMid(double mid) {
        this.mid = mid;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

  
   
    
    
   
   
}
