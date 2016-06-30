package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

/**
 * Created by Aagam Shah on 6/29/2016.
 */
public class ModuleTest extends AndroidTestCase {
    public void runModuleTest(){
        String joke = null;
        EndPointsAsyncTask endPointsAsyncTask = new EndPointsAsyncTask();
        endPointsAsyncTask.execute(getContext());
        try{
            joke = endPointsAsyncTask.get();
            Log.d("ModuleTest","Retrieved a non-empty joke succesfully" + joke);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        assertNotNull(joke);
    }
}
