package ru.netology

fun main() {
    val cardType = "MasterCard"
    val monthTransfer = 320_000_000L
    val transfer = 2_000_000L
    commissionAmount(cardType, monthTransfer, transfer)
}

private fun commissionAmount(
        cardType: String = "VK Pay",
        monthTransfer: Long = 0L,
        transfer: Long
): Long {
    return when (cardType) {
        "MasterCard", "Maestro" -> {
            calForMasterMaestroCard(monthTransfer, transfer)
        }
        "Visa", "Мир" -> {
           calForVisaMirCard(transfer)
        }
        "VK Pay" -> {
            println("Комиссия не взимается")
            0
        }
        else -> 0
    }
}

private fun calForVisaMirCard(transfer: Long): Long {
    val commission = transfer * 0.0075
    return if (commission > 3500) {
        println("Комиссия: $commission коп")
        commission.toLong()
    } else {
        println("Комиссия: 3500 коп")
        3500
    }
}

private fun calForMasterMaestroCard(monthTransfer: Long, transfer: Long): Long {
    return if (monthTransfer + transfer <= 7_500_000) {
        println("Комиссия не взимается")
        0
    } else {
        val commission = transfer * 0.006 + 2000
        println("Комиссия: $commission коп")
        commission.toLong()
    }
}
