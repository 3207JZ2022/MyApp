package edu.temple.myapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // check different sdk version issue

        // inflate
        // menu option context



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu) // inflate menu.main as menu
        return super.onCreateOptionsMenu(menu)

    }

    // when user click a menu item, we need to perform action for corresponding item
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // true if it is my item
        // switch
        when(item.itemId){
            R.id.action_take_picture -> Toast.makeText(this, "Taking picture" , Toast.LENGTH_SHORT).show()
            R.id.action_help -> startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.temple.edu")))
            R.id.action_delete_pict -> {
                AlertDialog.Builder(this)
                    .setTitle("Confirmation")
                    .setMessage("Are you sure you want to delete? This action cannot be undone.?")
                    .setPositiveButton("Yes"){
                        // lambda function that takes 2 arguments
                        _,_ -> Toast.makeText(this, "Deleting picture", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("Never mind"){
                        dialog,_ -> dialog.cancel()  // you can click outside of the dialog to cancel dialog
                    }
                    .setCancelable(false) // prevent cancel from click outside of the dialog
                    .create() // now create the dialog
                    .show() // now show the dialog
            }


            else -> return false
        }

        return true

        // false if not
//        return super.onOptionsItemSelected(item)
    }
}