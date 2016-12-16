package com.rcorp.kidselearning.com.rcorp.kidselearning.managers.com.rcorp.kidselearning.managers;

import android.content.res.Resources;

import com.rcorp.kidselearning.R;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.Random;

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

    JSONObject m_JsonExercice;
    int current = 0;
    String m_CurrentQuestion = "5 + 5 =";

    public ExercicesManager(ExerciceType p_Type, Resources p_Resources)
    {
        LoadJson(p_Type, p_Resources);
    }

    public String GetNextQuestion()
    {

        int index = new Random().nextInt(countIterator(m_JsonExercice.keys()));
        Iterator<String> l_Ite = m_JsonExercice.keys();
        int i = 0;
        while( l_Ite.hasNext() ) {
            String key = (String) l_Ite.next();
            if (i == index)
                m_CurrentQuestion = key;
            i++;
        }
        return (m_CurrentQuestion);
    }

    public int countIterator(Iterator<String> p_Iterator)
    {
        int result = 0;
        while( p_Iterator.hasNext() ) {
            String key = (String) p_Iterator.next();
            result++;
        }
        return result;
    }

    public void Submit()
    {

    }

    public void LoadJson(ExerciceType p_Type, Resources p_Resources)
    {
        InputStream is = null;
        if (p_Type == ExerciceType.ADD)
            is = p_Resources.openRawResource(R.raw.add);
        if (p_Type == ExerciceType.DIV)
            is = p_Resources.openRawResource(R.raw.div);
        if (p_Type == ExerciceType.MUL)
            is = p_Resources.openRawResource(R.raw.mul);
        if (p_Type == ExerciceType.SUB)
            is = p_Resources.openRawResource(R.raw.sub);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
            is.close();
            m_JsonExercice = new JSONObject(writer.toString());
        } catch (Exception e) {}
    }
}
