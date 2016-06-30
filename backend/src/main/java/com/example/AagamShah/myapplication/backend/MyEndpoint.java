/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.AagamShah.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.myapplication.AagamShah.example.com",
    ownerName = "backend.myapplication.AagamShah.example.com",
    packagePath=""
  )
)
public class MyEndpoint {

    /** A simple endpoint method that tells a Joke */
    @ApiMethod(name = "joke")
    public MyBean joke() {
       return new MyBean();
    }

}
