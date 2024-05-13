package com.xiaomi.fileproviderreceivetest

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.xiaomi.fileproviderreceivetest.ui.theme.FileProviderReceiveTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FileProviderReceiveTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
        val intent = intent
//        Toast.makeText(this, "aaa1111 ${intent.data}", 0).show()
//

        val uri = intent.data
        if (uri != null) {
            // 通过 ContentResolver 打开输入流，并读取文件内容
            contentResolver.openInputStream(uri)?.use { inputStream ->
                val content = inputStream.bufferedReader().use { it.readText() }
                Toast.makeText(this, "content: $content", 0).show()
                Log.d("FileContent", content)
                // 在这里可以对文件内容进行处理
            }
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "File Receive",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FileProviderReceiveTestTheme {
        Greeting("Android")
    }
}