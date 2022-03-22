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

package com.postmodern.postmoderndungeon.actors.buffs;

import com.postmodern.postmoderndungeon.Dungeon;
import com.postmodern.postmoderndungeon.actors.Char;
import com.postmodern.postmoderndungeon.messages.Messages;
import com.postmodern.postmoderndungeon.ui.BuffIndicator;

public class Foresight extends FlavourBuff {

	public static final float DURATION = 250f;

	public static final int DISTANCE = 8;

	{
		type = buffType.POSITIVE;
		announced = true;
	}
	
	@Override
	public int icon() {
		return BuffIndicator.FORESIGHT;
	}

	@Override
	public boolean attachTo(Char target) {
		if (super.attachTo(target)){
			//this way we get a nice VFX sweep on initial activation
			if (target == Dungeon.hero){
				Dungeon.level.mapped[target.pos] = false;
				Dungeon.hero.search(false);
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	public float iconFadePercent() {
		return Math.max(0, (DURATION - visualcooldown()) / DURATION);
	}
	
	@Override
	public String toString() {
		return Messages.get(this, "name");
	}
	
	@Override
	public String desc() {
		return Messages.get(this, "desc", dispTurns());
	}
}
