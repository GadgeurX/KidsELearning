package com.rcorp.kidselearning.com.rcorp.kidselearning.managers;

/**
 * Created by romain on 16/12/2016.
 */

public class ExercicesManager {

    public enum ExerciceType {
        ADD,
        SUB,
        MUL,
        DIV;
    }

    public ExercicesManager(ExerciceType p_Type)
    {

    }

    public String GetNextQuestion()
    {
        return ("5 + 5 = ");
    }

    public void Submit()
    {

    }
}
