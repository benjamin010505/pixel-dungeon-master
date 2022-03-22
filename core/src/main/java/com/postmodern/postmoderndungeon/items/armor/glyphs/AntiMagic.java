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

package com.postmodern.postmoderndungeon.items.armor.glyphs;

import com.postmodern.postmoderndungeon.actors.Char;
import com.postmodern.postmoderndungeon.actors.buffs.Charm;
import com.postmodern.postmoderndungeon.actors.buffs.Degrade;
import com.postmodern.postmoderndungeon.actors.buffs.Hex;
import com.postmodern.postmoderndungeon.actors.buffs.MagicalSleep;
import com.postmodern.postmoderndungeon.actors.buffs.Vulnerable;
import com.postmodern.postmoderndungeon.actors.buffs.Weakness;
import com.postmodern.postmoderndungeon.actors.hero.abilities.mage.WarpBeacon;
import com.postmodern.postmoderndungeon.actors.mobs.DM100;
import com.postmodern.postmoderndungeon.actors.mobs.Eye;
import com.postmodern.postmoderndungeon.actors.mobs.Shaman;
import com.postmodern.postmoderndungeon.actors.mobs.Warlock;
import com.postmodern.postmoderndungeon.actors.mobs.YogFist;
import com.postmodern.postmoderndungeon.items.armor.Armor;
import com.postmodern.postmoderndungeon.items.wands.WandOfBlastWave;
import com.postmodern.postmoderndungeon.items.wands.WandOfDisintegration;
import com.postmodern.postmoderndungeon.items.wands.WandOfFireblast;
import com.postmodern.postmoderndungeon.items.wands.WandOfFrost;
import com.postmodern.postmoderndungeon.items.wands.WandOfLightning;
import com.postmodern.postmoderndungeon.items.wands.WandOfLivingEarth;
import com.postmodern.postmoderndungeon.items.wands.WandOfMagicMissile;
import com.postmodern.postmoderndungeon.items.wands.WandOfPrismaticLight;
import com.postmodern.postmoderndungeon.items.wands.WandOfTransfusion;
import com.postmodern.postmoderndungeon.items.wands.WandOfWarding;
import com.postmodern.postmoderndungeon.levels.traps.DisintegrationTrap;
import com.postmodern.postmoderndungeon.levels.traps.GrimTrap;
import com.postmodern.postmoderndungeon.sprites.ItemSprite;
import com.watabou.utils.Random;

import java.util.HashSet;

public class AntiMagic extends Armor.Glyph {

	private static ItemSprite.Glowing TEAL = new ItemSprite.Glowing( 0x88EEFF );
	
	public static final HashSet<Class> RESISTS = new HashSet<>();
	static {
		RESISTS.add( MagicalSleep.class );
		RESISTS.add( Charm.class );
		RESISTS.add( Weakness.class );
		RESISTS.add( Vulnerable.class );
		RESISTS.add( Hex.class );
		RESISTS.add( Degrade.class );
		
		RESISTS.add( DisintegrationTrap.class );
		RESISTS.add( GrimTrap.class );

		RESISTS.add( WandOfBlastWave.class );
		RESISTS.add( WandOfDisintegration.class );
		RESISTS.add( WandOfFireblast.class );
		RESISTS.add( WandOfFrost.class );
		RESISTS.add( WandOfLightning.class );
		RESISTS.add( WandOfLivingEarth.class );
		RESISTS.add( WandOfMagicMissile.class );
		RESISTS.add( WandOfPrismaticLight.class );
		RESISTS.add( WandOfTransfusion.class );
		RESISTS.add( WandOfWarding.Ward.class );

		RESISTS.add( WarpBeacon.class );
		
		RESISTS.add( DM100.LightningBolt.class );
		RESISTS.add( Shaman.EarthenBolt.class );
		RESISTS.add( Warlock.DarkBolt.class );
		RESISTS.add( Eye.DeathGaze.class );
		RESISTS.add( YogFist.BrightFist.LightBeam.class );
		RESISTS.add( YogFist.DarkFist.DarkBolt.class );
	}
	
	@Override
	public int proc(Armor armor, Char attacker, Char defender, int damage) {
		//no proc effect, see Hero.damage and GhostHero.damage and ArmoredStatue.damage
		return damage;
	}
	
	public static int drRoll( int level ){
		return Random.NormalIntRange(level, 3 + Math.round(level*1.5f));
	}

	@Override
	public ItemSprite.Glowing glowing() {
		return TEAL;
	}

}