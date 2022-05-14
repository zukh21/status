fun main(){
    println(agoToText(172801))
}

fun minLastChar(sec: Int):String{
    var min = sec / 60
    var lastDigit = min % 10
    var lastTwoDigit = min % 100
    val lastCharT = intArrayOf(5, 6, 7, 8, 9, 0)
    val lastCharTExcept = intArrayOf(11, 12, 13, 14, 15, 16, 17, 18, 19)
    var lastChar = if (lastDigit in lastCharT || lastTwoDigit in lastCharTExcept){
//        println("${min} минут")
        return ("${min} минут")
    }else if (lastDigit == 1 && lastTwoDigit !in lastCharTExcept){
        return ("${min} минуту")
//        println("${min} минуту")
    }else{
        return ("${min} минуты")
//        println("${min} минуты")
    }
}

fun hourLastChar(sec: Int):String{
    var hour = (sec / 60) / 60
    var lastDigit = hour % 10
    var lastTwoDigit = hour % 100
    val lastCharT = intArrayOf(5, 6, 7, 8, 9, 0)
    val lastCharTExcept = intArrayOf(11, 12, 13, 14, 15, 16, 17, 18, 19)
    var lastChar = if (lastDigit in lastCharT || lastTwoDigit in lastCharTExcept){
        return ("${hour} час")
//        println("${hour} час")
    }else if (lastDigit == 1 && lastTwoDigit !in lastCharTExcept){
        return ("${hour} часа")
//        println("${hour} часа")
    }else{
        return ("${hour} часы")
//        println("${hour} часы")
    }
}

fun agoToText(sec:Int): String{
    val oneHour = 60 * 60
    val oneDay = 24 * 60 * 60
    when(sec){
        in 0..60 -> return "только что"
        in 61..oneHour -> return "${minLastChar(sec)} назад"
        in oneHour + 1 .. oneDay -> return "${hourLastChar(sec)} назад"
        in oneDay + 1..oneDay*2 -> return "сегодня"
        in oneDay * 2 + 1 .. oneDay * 2 + oneDay -> return "вчера"
        else -> return "давно"
    }
}

