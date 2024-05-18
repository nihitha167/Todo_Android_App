package com.nihitha.todolistapp

import android.content.Context
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class FileHelper {

    val FILENAME="listinfo.dat" // data will be saved

    fun writeData(item:ArrayList<String>,context: Context){ // write data to file

        // save data on device , write data on file
        var fos : FileOutputStream = context.openFileOutput(FILENAME,Context.MODE_PRIVATE) // it will create file in device's memory and open it

        var oas = ObjectOutputStream(fos)
        oas.writeObject(item)
        oas.close()

    }

    fun readData(context: Context) :ArrayList<String>{
        var itemList:ArrayList<String>
        try{
            var fis:FileInputStream = context.openFileInput(FILENAME)
            var ois = ObjectInputStream(fis)
            itemList = ois.readObject() as ArrayList<String>

        }catch(e:FileNotFoundException){
            itemList=ArrayList()

        }
        return itemList
    }


}