package sample.EmpireData;

import sample.Enums.Job;

public class Pop {
    private Species species;
    private Job job = Job.WORKER;


    public Pop(Species species){
        this.species = species;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }


}
