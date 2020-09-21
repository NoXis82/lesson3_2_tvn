package ru.netology

import java.math.BigDecimal

fun main() {
    val cardType = "MasterCard"
    val monthTransfer: BigDecimal = BigDecimal.valueOf(320_000_000)
    val transfer: BigDecimal = BigDecimal.valueOf(200_000)
    commissionAmount(cardType, monthTransfer, transfer)
}

private fun commissionAmount(
    cardType: String = "VK Pay",
    monthTransfer: BigDecimal = BigDecimal.valueOf(0),
    transfer: BigDecimal
) {
    when (cardType) {
        "MasterCard", "Maestro" -> {
            calForMasterMaestroCard(monthTransfer, transfer)
        }
        "Visa", "Мир" -> {
            calForVisaMirCard(transfer)
        }
        "VK Pay" -> println("Комиссия не взимается")
    }
}

private fun calForVisaMirCard(transfer: BigDecimal) {
    val commission = transfer.times(0.0075.toBigDecimal())
    if (commission > (3500).toBigDecimal()) {
        println("Комиссия: $commission коп")
        val totalTransfer = (transfer.plus(commission)).div(100.toBigDecimal())
        println("Итого с комиссией: $totalTransfer руб")
    } else {
        println("Комиссия: 3500 коп")
        val totalTransfer = (transfer.plus(3500.toBigDecimal())).div(100.toBigDecimal())
        println("Итого с комиссией: $totalTransfer руб")
    }
}

private fun calForMasterMaestroCard(monthTransfer: BigDecimal, transfer: BigDecimal) {
    if (monthTransfer.add(transfer) <= 7_500_000.toBigDecimal()) {
        println("Комиссия не взимается")
    } else {
        val commission = transfer.times(0.006.toBigDecimal()).plus(2000.toBigDecimal())
        println("Комиссия: $commission коп")
        val totalTransfer = (transfer.plus(commission)).div(100.toBigDecimal())
        println("Итого с комиссией: $totalTransfer руб")
    }
}
