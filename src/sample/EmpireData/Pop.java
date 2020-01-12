package sample.EmpireData;

import sample.Enums.Job;

public class Pop {
    private Species species;
    private Job job;


    public Pop(Species species){
        this.species = species;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
