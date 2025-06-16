package com.example.simple_calculator

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simple_calculator.ui.theme.Simple_CalculatorTheme
import java.lang.Math.pow
import kotlin.math.pow
import kotlin.math.round

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Simple_CalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CalculatorLogic(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CalculatorUI(
    backgroundColor: Color,
    bColor1: Color,
    fontColor: Color,
    bColor2: Color,
    bColor3: Color,
    one :() -> Unit,
    two :() -> Unit,
    three :() -> Unit,
    four :() -> Unit,
    five :() -> Unit,
    six :() -> Unit,
    seven :() -> Unit,
    eight :() -> Unit,
    nine :() -> Unit,
    zero :() -> Unit,
    power :() -> Unit,
    divide :() -> Unit,
    multiply :() -> Unit,
    plus :() -> Unit,
    minus :() -> Unit,
    decimal :() -> Unit,
    delete :() -> Unit,
    clear :() -> Unit,
    hogwarts :() -> Unit,
    equals :() -> Unit,
    res : String,
    modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize().background(backgroundColor).safeDrawingPadding()) {
        Column(modifier = Modifier.weight(5F).fillMaxSize().padding(12.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom) {
            Text(text = res.replace(",",""),
                fontSize = 40.sp,
                lineHeight = 45.sp,
                textAlign = TextAlign.Right,
                color = fontColor,
                modifier= Modifier.padding(8.dp))
        }
        Column(modifier = Modifier.weight(7F).fillMaxSize().padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
            verticalArrangement = Arrangement.SpaceEvenly) {

            Row(modifier = Modifier.fillMaxSize().weight(1F),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Button(onClick = clear,
                    modifier = Modifier.fillMaxSize().weight(1f).padding(vertical = 5.dp, horizontal = 5.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = bColor2),
                    elevation = ButtonDefaults.buttonElevation(6.dp,12.dp),
                    //border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text(text = "AC",
                        color = fontColor,
                        fontSize = 24.sp,
                    )
                }
                Button(onClick = delete,
                    modifier = Modifier.fillMaxSize().weight(1f).padding(vertical = 5.dp, horizontal = 5.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = bColor2),
                    elevation = ButtonDefaults.buttonElevation(6.dp,12.dp),
                    //border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text(text = "C",
                        color = fontColor,
                        fontSize = 24.sp
                    )
                }

                Button(onClick = hogwarts,
                    colors = ButtonDefaults.buttonColors(containerColor = bColor2),
                    modifier = Modifier.fillMaxSize().weight(1f).padding(vertical = 5.dp, horizontal = 5.dp),
                    shape = CircleShape,
                    elevation = ButtonDefaults.buttonElevation(6.dp,12.dp),
                    //border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text(text = "W",
                        color = fontColor,
                        fontSize = 24.sp
                    )
                }
                Button(onClick = divide,
                    modifier = Modifier.fillMaxSize().weight(1f).padding(vertical = 5.dp, horizontal = 5.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = bColor3),
                    elevation = ButtonDefaults.buttonElevation(6.dp,12.dp),
                    //border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text(text = "÷",
                        color = fontColor,
                        fontSize = 30.sp
                    )
                }
            }
            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize().weight(1F)
            ) {
                Button(onClick = seven,
                    modifier = Modifier.fillMaxSize().weight(1f).padding(vertical = 5.dp, horizontal = 5.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = bColor1),
                    elevation = ButtonDefaults.buttonElevation(6.dp,12.dp),
                    //border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text(text = "7",
                        color = fontColor,
                        fontSize = 30.sp
                    )
                }

                Button(onClick = eight,
                    modifier = Modifier.fillMaxSize().weight(1f).padding(vertical = 5.dp, horizontal = 5.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = bColor1),
                    elevation = ButtonDefaults.buttonElevation(6.dp,12.dp),
                    //border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text(text = "8",
                        color = fontColor,
                        fontSize = 30.sp
                    )
                }
                Button(onClick = nine,
                    modifier = Modifier.fillMaxSize().weight(1f).padding(vertical = 5.dp, horizontal = 5.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = bColor1),
                    elevation = ButtonDefaults.buttonElevation(6.dp,12.dp),
                    //border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text(text = "9",
                        color = fontColor,
                        fontSize = 30.sp
                    )
                }
                Button(onClick = multiply,
                    modifier = Modifier.fillMaxSize().weight(1f).padding(vertical = 5.dp, horizontal = 5.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = bColor3),
                    elevation = ButtonDefaults.buttonElevation(6.dp,12.dp),
                    //border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text(text = "x",
                        color = fontColor,
                        fontSize = 30.sp
                    )
                }
            }
            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize().weight(1F)
            ) {
                Button(onClick = four,
                    modifier = Modifier.fillMaxSize().weight(1f).padding(vertical = 5.dp, horizontal = 5.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = bColor1),
                    elevation = ButtonDefaults.buttonElevation(6.dp,12.dp),
                    //border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text(text = "4",
                        color = fontColor,
                        fontSize = 30.sp
                    )
                }

                Button(onClick = five,
                    modifier = Modifier.fillMaxSize().weight(1f).padding(vertical = 5.dp, horizontal = 5.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = bColor1),
                    elevation = ButtonDefaults.buttonElevation(6.dp,12.dp),
                    //border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text(text = "5",
                        color = fontColor,
                        fontSize = 30.sp
                    )
                }
                Button(onClick = six,
                    modifier = Modifier.fillMaxSize().weight(1f).padding(vertical = 5.dp, horizontal = 5.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = bColor1),
                    elevation = ButtonDefaults.buttonElevation(6.dp,12.dp),
                    //border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text(text = "6",
                        color = fontColor,
                        fontSize = 30.sp
                    )
                }
                Button(onClick = minus,
                    modifier = Modifier.fillMaxSize().weight(1f).padding(vertical = 5.dp, horizontal = 5.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = bColor3),
                    elevation = ButtonDefaults.buttonElevation(6.dp,12.dp),
                    //border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text(text = "-",
                        color = fontColor,
                        fontSize = 36.sp
                    )
                }
            }
            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize().weight(1F)
            ) {
                Button(onClick = one,
                    modifier = Modifier.fillMaxSize().weight(1f).padding(vertical = 5.dp, horizontal = 5.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = bColor1),
                    elevation = ButtonDefaults.buttonElevation(6.dp,12.dp),
                    //border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text(text = "1",
                        color = fontColor,
                        fontSize = 30.sp
                    )
                }
                Button(onClick = two,
                    modifier = Modifier.fillMaxSize().weight(1f).padding(vertical = 5.dp, horizontal = 5.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = bColor1),
                    elevation = ButtonDefaults.buttonElevation(6.dp,12.dp),
                    //border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text(text = "2",
                        color = fontColor,
                        fontSize = 30.sp
                    )
                }
                Button(onClick = three,
                    modifier = Modifier.fillMaxSize().weight(1f).padding(vertical = 5.dp, horizontal = 5.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = bColor1),
                    elevation = ButtonDefaults.buttonElevation(6.dp,12.dp),
                    //border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text(text = "3",
                        color = fontColor,
                        fontSize = 30.sp
                    )
                }
                Button(onClick = plus,
                    modifier = Modifier.fillMaxSize().weight(1f).padding(vertical = 5.dp, horizontal = 5.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = bColor3),
                    elevation = ButtonDefaults.buttonElevation(6.dp,12.dp),
                    //border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text(text = "+",
                        color = fontColor,
                        fontSize = 30.sp
                    )
                }
            }
            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize().weight(1F)
            ) {
                Button(onClick = power,
                    modifier = Modifier.fillMaxSize().weight(1f).padding(vertical = 5.dp, horizontal = 5.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = bColor1),
                    elevation = ButtonDefaults.buttonElevation(6.dp,12.dp),
                    //border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text(text = "^",
                        color = fontColor,
                        fontSize = 30.sp
                    )
                }
                Button(onClick = zero,
                    modifier = Modifier.fillMaxSize().weight(1f).padding(vertical = 5.dp, horizontal = 5.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = bColor1),
                    elevation = ButtonDefaults.buttonElevation(6.dp,12.dp),
                    //border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text(text = "0",
                        color = fontColor,
                        fontSize = 30.sp
                    )
                }
                Button(onClick = decimal,
                    modifier = Modifier.fillMaxSize().weight(1f).padding(vertical = 5.dp, horizontal = 5.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = bColor1),
                    elevation = ButtonDefaults.buttonElevation(6.dp,12.dp),
                    //border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text(text = ".",
                        color = fontColor,
                        fontSize = 36.sp
                    )
                }
                Button(onClick = equals,
                    modifier = Modifier.fillMaxSize().weight(1f).padding(vertical = 5.dp, horizontal = 5.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = bColor3),
                    elevation = ButtonDefaults.buttonElevation(6.dp,12.dp),
                    //border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text(text = "=",
                        color = fontColor,
                        fontSize = 30.sp
                    )
                }
            }
        }
    }

}

@Composable
fun CalculatorLogic(modifier: Modifier= Modifier){
    var str by remember { mutableStateOf("") }
    var res by remember { mutableStateOf("") }
    var cstate by remember { mutableStateOf(0) }
    var lt = mutableListOf<String>()
    var temp = mutableListOf<String>()
    var temp2 = mutableListOf<String>()
    var a :Int
    var b: Double
    var c: Double
    var r: String
    val (backgroundColor, bColor1, fontColor) = when (cstate) {
        0 -> Triple(Color(72,26,28,255), Color(126,0,1,255), Color(253,162,55,255)) // Gryffindor
        1 -> Triple(Color(0,53,23,255), Color(28,99,41,255), Color.Gray) // Slytherin
        2 -> Triple(Color(27,44,83), Color(2, 59, 135), Color(184,134,61,255)) // Ravenclaw
        else -> Triple(Color(94, 57, 40,255), Color(201,148,42,255), Color(0,0,0)) // Hufflepuff
    }
    val(bColor2, bColor3)= when(cstate) {
        0 -> Pair(Color(129,66,40), Color(171,58,18,255))
        1 -> Pair(Color(2,57,51,255), Color(76, 117, 78))
        2 -> Pair(Color(1,121,184,255), Color(59,103,152,255))
        else -> Pair(Color(241,153,1,255), Color(179, 134, 75))
    }

    val one:() -> Unit = { str += "1"; res=str }
    val two:() -> Unit = { str += "2"; res=str }
    val three:() -> Unit = { str += "3"; res=str }
    val four:() -> Unit = { str += "4"; res=str }
    val five:() -> Unit = { str += "5"; res=str }
    val six:() -> Unit = { str += "6"; res=str }
    val seven:() -> Unit = { str += "7"; res=str }
    val eight:() -> Unit = { str += "8"; res=str }
    val nine:() -> Unit = { str += "9"; res=str }
    val zero:() -> Unit = { str += "0"; res=str }
    val plus:() -> Unit = { str += ",+,"; res=str }
    val minus:() -> Unit = { str += ",-,"; res=str }
    val multiply:() -> Unit = { str += ",x,"; res=str }
    val divide:() -> Unit = { str += ",÷,"; res=str }
    val power:() -> Unit = { str += ",^,"; res=str }
    val decimal:() -> Unit = { str += "."; res=str }
    val delete:() -> Unit = {
        if(str.isNotEmpty()) {
            if (str[str.length - 1] == ',') {
                str = str.substring(0, str.length - 3)
            } else {
                str = str.substring(0, str.length - 1)
            }
            res = str
        }
    }
    var clear:() -> Unit = { str= ""; res=str }
    var hogwarts:() -> Unit = { cstate = (cstate +1 ) % 4}
    var equals:() -> Unit = {
        lt.clear()
        temp.clear()
        temp2.clear()
        if(str.isEmpty()|| str[str.length-1]==',' || str.contains(",,")||str.contains("..")||str.startsWith(",")){
            res="Invalid Input"
            str=""
        }
        else{
            lt= str.split(",").toMutableList()
            for( ch in lt){
                if(ch=="^"|| ch=="÷"||ch=="x"||ch=="+"||ch=="-"){
                    if(temp2.isEmpty()){
                       temp2.add(ch)
                   }
                    else if(Order(ch) > Order(temp2.last())){
                       temp2.add(ch)
                   }
                    else{
                        while (temp2.isNotEmpty() &&
                            ((Order(ch) < Order(temp2.last())) ||
                                    (Order(ch) == Order(temp2.last()) && ch != "^"))
                        ){
                            temp.add(temp2.removeAt(temp2.lastIndex))
                           }
                        temp2.add(ch)
                   }
               }
                else{
                   temp.add(ch)
               }

            }
            while (temp2.isNotEmpty()) {
                temp.add(temp2.removeAt(temp2.lastIndex))
            }
            while(temp.size != 1){
                try {
                    for(ch in temp){
                        if(ch=="^"){
                            a = temp.indexOf(ch)
                            temp.removeAt(a)
                            c = temp.removeAt(a-1).toDouble()
                            b = temp.removeAt(a-2).toDouble()
                            r = (b.pow(c)).toString()
                            temp.add((a-2),r)
                            break
                        }
                        else if(ch=="÷"){
                            a = temp.indexOf(ch)
                            temp.removeAt(a)
                            c = temp.removeAt(a-1).toDouble()
                            b = temp.removeAt(a-2).toDouble()
                            r = (b/c).toString()
                            temp.add((a-2),r)
                            break
                        }
                        else if(ch=="x"){
                            a = temp.indexOf(ch)
                            temp.removeAt(a)
                            c = temp.removeAt(a-1).toDouble()
                            b = temp.removeAt(a-2).toDouble()
                            r = (b*c).toString()
                            temp.add((a-2),r)
                            break
                        }
                        else if(ch=="+"){
                            a = temp.indexOf(ch)
                            temp.removeAt(a)
                            c = temp.removeAt(a-1).toDouble()
                            b = temp.removeAt(a-2).toDouble()
                            r = (b+c).toString()
                            temp.add((a-2),r)
                            break
                        }
                        else if(ch=="-"){
                            a = temp.indexOf(ch)
                            temp.removeAt(a)
                            c = temp.removeAt(a-1).toDouble()
                            b = temp.removeAt(a-2).toDouble()
                            r = (b-c).toString()
                            temp.add((a-2),r)
                            break
                        }
                    }
                }
                catch (e: Exception) {
                    res= "Illegal expression requested"
                }
            }

            if (temp.size != 1) {
                res = "Illegal expression requested"
            }
            else {
                val nw = temp[0].toDouble()
                res = if( round(nw)==nw && (nw <= Int.MAX_VALUE && nw >= Int.MIN_VALUE)){
                    nw.toInt().toString()
                    }
                    else{
                    nw.toString()
                    }
                str=res
            }


        }
    }
    CalculatorUI(
        backgroundColor = backgroundColor,
        bColor1 = bColor1,
        fontColor = fontColor,
        bColor2 = bColor2,
        bColor3 = bColor3,
        one = one,
        two = two,
        three = three ,
        four = four ,
        five = five ,
        six = six,
        seven = seven ,
        eight = eight ,
        nine = nine ,
        zero = zero ,
        power = power ,
        divide = divide ,
        multiply = multiply ,
        plus = plus ,
        minus = minus ,
        decimal = decimal ,
        delete = delete ,
        clear = clear ,
        hogwarts = hogwarts,
        equals = equals,
        res = res
    )

}

fun Order(op:String): Int{
    return when(op){
        "^" -> 3
        "÷","x" -> 2
        "+","-" -> 1
        else -> 0
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Simple_CalculatorTheme {
        CalculatorLogic()
    }
}