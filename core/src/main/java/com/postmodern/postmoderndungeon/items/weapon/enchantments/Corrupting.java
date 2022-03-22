/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2021 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.postmodern.postmoderndungeon.items.weapon.enchantments;

import com.postmodern.postmoderndungeon.Badges;
import com.postmodern.postmoderndungeon.Dungeon;
import com.postmodern.postmoderndungeon.Statistics;
import com.postmodern.postmoderndungeon.actors.Char;
import com.postmodern.postmoderndungeon.actors.buffs.AllyBuff;
import com.postmodern.postmoderndungeon.actors.buffs.Buff;
import com.postmodern.postmoderndungeon.actors.buffs.Corruption;
import com.postmodern.postmoderndungeon.actors.buffs.PinCushion;
import com.postmodern.postmoderndungeon.actors.buffs.SoulMark;
import com.postmodern.postmoderndungeon.actors.hero.Hero;
import com.postmodern.postmoderndungeon.actors.mobs.Mob;
import com.postmodern.postmoderndungeon.items.weapon.Weapon;
import com.postmodern.postmoderndungeon.messages.Messages;
import com.postmodern.postmoderndungeon.sprites.CharSprite;
import com.postmodern.postmoderndungeon.sprites.ItemSprite;
import com.watabou.utils.Random;

public class Corrupting extends Weapon.Enchantment {
	
	private static ItemSprite.Glowing BLACK = new ItemSprite.Glowing( 0x440066 );
	
	@Override
	public int proc(Weapon weapon, Char attacker, Char defender, int damage) {
		int level = Math.max( 0, weapon.buffedLvl() );
		
		// lvl 0 - 20%
		// lvl 1 ~ 23%
		// lvl 2 ~ 26%
		float procChance = (level+5f)/(level+25f) * procChanceMultiplier(attacker);
		if (damage >= defender.HP
				&& Random.Float() < procChance
				&& !defender.isImmune(Corruption.class)
				&& defender.buff(Corruption.class) == null
				&& defender instanceof Mob
				&& defender.isAlive()){
			
			Mob enemy = (Mob) defender;
			Hero hero = (attacker instanceof Hero) ? (Hero) attacker : Dungeon.hero;

			Corruption.corruptionHeal(enemy);

			AllyBuff.affectAndLoot(enemy, hero, Corruption.class);
			
			return 0;
		}
		
		return damage;
	}
	
	@Override
	public ItemSprite.Glowing glowing() {
		return BLACK;
	}
}
