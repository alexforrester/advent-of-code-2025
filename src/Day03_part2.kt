private var counter = 0

fun main() {


    val input = readInput("Day03")

    input.forEach { batteryBank ->

        val batteryBankList = batteryBank.toList()
        val sortedBatteryBankList = batteryBankList.sorted().reversed()

        println("batteryBankList.size: ${batteryBankList.size}")

        val currentHighestPosition = batteryBankList.indexOf(sortedBatteryBankList[0])
        val currentHighest = sortedBatteryBankList[0]

        println("currentHighestPosition: $currentHighestPosition")
        println("currentHighest: $currentHighest")

        val adjustedHighestPosition = if (currentHighestPosition != batteryBankList.size-1) {
            batteryBankList.indexOf(sortedBatteryBankList[0])
        } else {
            batteryBankList.indexOf(sortedBatteryBankList[1])
        }

        val adjustedHighest = batteryBankList[adjustedHighestPosition]

        println("adjustedHighestPosition: $adjustedHighestPosition")
        println("adjustedHighest: $adjustedHighest")

        val nextHighest = if (adjustedHighestPosition == currentHighestPosition) {
            batteryBankList.subList(adjustedHighestPosition+1, batteryBankList.size).sorted().reversed()[0]
        }
        else {
            batteryBankList.subList(0, batteryBankList.size).sorted().reversed()[0]
        }

        batteryBankList.subList(adjustedHighestPosition, batteryBankList.size).sorted().reversed()[0]

        val lineAnswer =  "$adjustedHighest$nextHighest".toInt()
        counter += lineAnswer
    }

    print("Answer: $counter")
}