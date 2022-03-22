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

package com.postmodern.postmoderndungeon.items.spells;

import com.postmodern.postmoderndungeon.Dungeon;
import com.postmodern.postmoderndungeon.actors.Actor;
import com.postmodern.postmoderndungeon.actors.Char;
import com.postmodern.postmoderndungeon.actors.buffs.Buff;
import com.postmodern.postmoderndungeon.actors.buffs.Paralysis;
import com.postmodern.postmoderndungeon.actors.hero.Hero;
import com.postmodern.postmoderndungeon.effects.Splash;
import com.postmodern.postmoderndungeon.items.potions.exotic.PotionOfStormClouds;
import com.postmodern.postmoderndungeon.mechanics.Ballistica;
import com.postmodern.postmoderndungeon.sprites.ItemSpriteSheet;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

public class AquaBlast extends TargetedSpell {
	
	{
		image = ItemSpriteSheet.AQUA_BLAST;
	}
	
	@Override
	protected void affectTarget(Ballistica bolt, Hero hero) {
		int cell = bolt.collisionPos;
		
		Splash.at(cell, 0x00AAFF, 10);
		
		for (int i : PathFinder.NEIGHBOURS9){
			if (i == 0 || Random.Int(5) != 0){
				Dungeon.level.setCellToWater(false, cell+i);
			}
		}
		
		Char target = Actor.findChar(cell);
		
		if (target != null && target != hero){
			//just enough to skip their current turn
			Buff.affect(target, Paralysis.class, target.cooldown());
		}
	}
	
	@Override
	public int value() {
		//prices of ingredients, divided by output quantity
		return Math.round(quantity * ((60 + 40) / 12f));
	}
	
	public static class Recipe extends com.postmodern.postmoderndungeon.items.Recipe.SimpleRecipe {
		
		{
			inputs =  new Class[]{PotionOfStormClouds.class, ArcaneCatalyst.class};
			inQuantity = new int[]{1, 1};
			
			cost = 2;
			
			output = AquaBlast.class;
			outQuantity = 12;
		}
		
	}
}
