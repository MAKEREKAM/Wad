package kr.vanilage.main

import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.util.Random

class CommandListener : CommandExecutor {
    val rd = Random()

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (args?.size != 5) return false //청크 반지름, 블록 타입, 청크당 생성 시도 수, Ymin, Ymax
        if (sender !is Player) return false
        if (!isInteger(args[0])) return false
        if (!isMaterial(args[1])) return false
        if (!Material.valueOf(args[1]).isBlock) return false
        if (!isInteger(args[2])) return false
        if (!isInteger(args[3])) return false
        if (!isInteger(args[4])) return false

        for (xChunk in -1 * args[0].toInt()..args[0].toInt()) {
            for (zChunk in -1 * args[0].toInt()..args[0].toInt()) {
                val chunk = (sender as Player).world.getChunkAt(xChunk, zChunk)
                for (i in 1..args[2].toInt()) {
                    val y = rd.nextInt(-64, 321)
                    if (y > args[3].toInt() || y < args[4].toInt()) continue
                    val x = rd.nextInt(16)
                    val z = rd.nextInt(16)

                    val block = chunk.getBlock(x, y, z)

                    if (block.type == Material.STONE || block.type == Material.DEEPSLATE) {
                        block.type = Material.valueOf(args[1])
                    }
                }
            }
        }

        return false
    }

    private fun isInteger(s: String): Boolean {
        return try {
            s.toInt()
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun isMaterial(s: String): Boolean {
        return try {
            Material.valueOf(s).name
            true
        } catch (e: Exception) {
            false
        }
    }
}