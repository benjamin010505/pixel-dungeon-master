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

package com.postmodern.postmoderndungeon.items;

import com.postmodern.postmoderndungeon.Dungeon;
import com.postmodern.postmoderndungeon.items.armor.Armor;
import com.postmodern.postmoderndungeon.items.armor.ClothArmor;
import com.postmodern.postmoderndungeon.items.armor.LeatherArmor;
import com.postmodern.postmoderndungeon.items.armor.MailArmor;
import com.postmodern.postmoderndungeon.items.armor.PlateArmor;
import com.postmodern.postmoderndungeon.items.armor.ScaleArmor;
import com.postmodern.postmoderndungeon.items.artifacts.AlchemistsToolkit;
import com.postmodern.postmoderndungeon.items.artifacts.Artifact;
import com.postmodern.postmoderndungeon.items.artifacts.CapeOfThorns;
import com.postmodern.postmoderndungeon.items.artifacts.ChaliceOfBlood;
import com.postmodern.postmoderndungeon.items.artifacts.CloakOfShadows;
import com.postmodern.postmoderndungeon.items.artifacts.DriedRose;
import com.postmodern.postmoderndungeon.items.artifacts.EtherealChains;
import com.postmodern.postmoderndungeon.items.artifacts.HornOfPlenty;
import com.postmodern.postmoderndungeon.items.artifacts.LloydsBeacon;
import com.postmodern.postmoderndungeon.items.artifacts.MasterThievesArmband;
import com.postmodern.postmoderndungeon.items.artifacts.SandalsOfNature;
import com.postmodern.postmoderndungeon.items.artifacts.TalismanOfForesight;
import com.postmodern.postmoderndungeon.items.artifacts.TimekeepersHourglass;
import com.postmodern.postmoderndungeon.items.artifacts.UnstableSpellbook;
import com.postmodern.postmoderndungeon.items.food.Food;
import com.postmodern.postmoderndungeon.items.food.MysteryMeat;
import com.postmodern.postmoderndungeon.items.food.Pasty;
import com.postmodern.postmoderndungeon.items.potions.Potion;
import com.postmodern.postmoderndungeon.items.potions.PotionOfExperience;
import com.postmodern.postmoderndungeon.items.potions.PotionOfFrost;
import com.postmodern.postmoderndungeon.items.potions.PotionOfHaste;
import com.postmodern.postmoderndungeon.items.potions.PotionOfHealing;
import com.postmodern.postmoderndungeon.items.potions.PotionOfInvisibility;
import com.postmodern.postmoderndungeon.items.potions.PotionOfLevitation;
import com.postmodern.postmoderndungeon.items.potions.PotionOfLiquidFlame;
import com.postmodern.postmoderndungeon.items.potions.PotionOfMindVision;
import com.postmodern.postmoderndungeon.items.potions.PotionOfParalyticGas;
import com.postmodern.postmoderndungeon.items.potions.PotionOfPurity;
import com.postmodern.postmoderndungeon.items.potions.PotionOfStrength;
import com.postmodern.postmoderndungeon.items.potions.PotionOfToxicGas;
import com.postmodern.postmoderndungeon.items.rings.Ring;
import com.postmodern.postmoderndungeon.items.rings.RingOfAccuracy;
import com.postmodern.postmoderndungeon.items.rings.RingOfElements;
import com.postmodern.postmoderndungeon.items.rings.RingOfEnergy;
import com.postmodern.postmoderndungeon.items.rings.RingOfEvasion;
import com.postmodern.postmoderndungeon.items.rings.RingOfForce;
import com.postmodern.postmoderndungeon.items.rings.RingOfFuror;
import com.postmodern.postmoderndungeon.items.rings.RingOfHaste;
import com.postmodern.postmoderndungeon.items.rings.RingOfMight;
import com.postmodern.postmoderndungeon.items.rings.RingOfSharpshooting;
import com.postmodern.postmoderndungeon.items.rings.RingOfTenacity;
import com.postmodern.postmoderndungeon.items.rings.RingOfWealth;
import com.postmodern.postmoderndungeon.items.scrolls.Scroll;
import com.postmodern.postmoderndungeon.items.scrolls.ScrollOfIdentify;
import com.postmodern.postmoderndungeon.items.scrolls.ScrollOfLullaby;
import com.postmodern.postmoderndungeon.items.scrolls.ScrollOfMagicMapping;
import com.postmodern.postmoderndungeon.items.scrolls.ScrollOfMirrorImage;
import com.postmodern.postmoderndungeon.items.scrolls.ScrollOfRage;
import com.postmodern.postmoderndungeon.items.scrolls.ScrollOfRecharging;
import com.postmodern.postmoderndungeon.items.scrolls.ScrollOfRemoveCurse;
import com.postmodern.postmoderndungeon.items.scrolls.ScrollOfRetribution;
import com.postmodern.postmoderndungeon.items.scrolls.ScrollOfTeleportation;
import com.postmodern.postmoderndungeon.items.scrolls.ScrollOfTerror;
import com.postmodern.postmoderndungeon.items.scrolls.ScrollOfTransmutation;
import com.postmodern.postmoderndungeon.items.scrolls.ScrollOfUpgrade;
import com.postmodern.postmoderndungeon.items.stones.Runestone;
import com.postmodern.postmoderndungeon.items.stones.StoneOfFear;
import com.postmodern.postmoderndungeon.items.stones.StoneOfAggression;
import com.postmodern.postmoderndungeon.items.stones.StoneOfAugmentation;
import com.postmodern.postmoderndungeon.items.stones.StoneOfBlast;
import com.postmodern.postmoderndungeon.items.stones.StoneOfBlink;
import com.postmodern.postmoderndungeon.items.stones.StoneOfClairvoyance;
import com.postmodern.postmoderndungeon.items.stones.StoneOfDeepSleep;
import com.postmodern.postmoderndungeon.items.stones.StoneOfDisarming;
import com.postmodern.postmoderndungeon.items.stones.StoneOfEnchantment;
import com.postmodern.postmoderndungeon.items.stones.StoneOfFlock;
import com.postmodern.postmoderndungeon.items.stones.StoneOfIntuition;
import com.postmodern.postmoderndungeon.items.stones.StoneOfShock;
import com.postmodern.postmoderndungeon.items.wands.Wand;
import com.postmodern.postmoderndungeon.items.wands.WandOfBlastWave;
import com.postmodern.postmoderndungeon.items.wands.WandOfCorrosion;
import com.postmodern.postmoderndungeon.items.wands.WandOfCorruption;
import com.postmodern.postmoderndungeon.items.wands.WandOfDisintegration;
import com.postmodern.postmoderndungeon.items.wands.WandOfFireblast;
import com.postmodern.postmoderndungeon.items.wands.WandOfFrost;
import com.postmodern.postmoderndungeon.items.wands.WandOfLightning;
import com.postmodern.postmoderndungeon.items.wands.WandOfLivingEarth;
import com.postmodern.postmoderndungeon.items.wands.WandOfMagicMissile;
import com.postmodern.postmoderndungeon.items.wands.WandOfPrismaticLight;
import com.postmodern.postmoderndungeon.items.wands.WandOfRegrowth;
import com.postmodern.postmoderndungeon.items.wands.WandOfTransfusion;
import com.postmodern.postmoderndungeon.items.wands.WandOfWarding;
import com.postmodern.postmoderndungeon.items.weapon.melee.AssassinsBlade;
import com.postmodern.postmoderndungeon.items.weapon.melee.BattleAxe;
import com.postmodern.postmoderndungeon.items.weapon.melee.Crossbow;
import com.postmodern.postmoderndungeon.items.weapon.melee.Dagger;
import com.postmodern.postmoderndungeon.items.weapon.melee.Dirk;
import com.postmodern.postmoderndungeon.items.weapon.melee.Flail;
import com.postmodern.postmoderndungeon.items.weapon.melee.Gauntlet;
import com.postmodern.postmoderndungeon.items.weapon.melee.Glaive;
import com.postmodern.postmoderndungeon.items.weapon.melee.Gloves;
import com.postmodern.postmoderndungeon.items.weapon.melee.Greataxe;
import com.postmodern.postmoderndungeon.items.weapon.melee.Greatshield;
import com.postmodern.postmoderndungeon.items.weapon.melee.Greatsword;
import com.postmodern.postmoderndungeon.items.weapon.melee.HandAxe;
import com.postmodern.postmoderndungeon.items.weapon.melee.Longsword;
import com.postmodern.postmoderndungeon.items.weapon.melee.Mace;
import com.postmodern.postmoderndungeon.items.weapon.melee.MagesStaff;
import com.postmodern.postmoderndungeon.items.weapon.melee.MeleeWeapon;
import com.postmodern.postmoderndungeon.items.weapon.melee.Quarterstaff;
import com.postmodern.postmoderndungeon.items.weapon.melee.RoundShield;
import com.postmodern.postmoderndungeon.items.weapon.melee.RunicBlade;
import com.postmodern.postmoderndungeon.items.weapon.melee.Sai;
import com.postmodern.postmoderndungeon.items.weapon.melee.Scimitar;
import com.postmodern.postmoderndungeon.items.weapon.melee.Shortsword;
import com.postmodern.postmoderndungeon.items.weapon.melee.Spear;
import com.postmodern.postmoderndungeon.items.weapon.melee.Sword;
import com.postmodern.postmoderndungeon.items.weapon.melee.WarHammer;
import com.postmodern.postmoderndungeon.items.weapon.melee.Whip;
import com.postmodern.postmoderndungeon.items.weapon.melee.WornShortsword;
import com.postmodern.postmoderndungeon.items.weapon.missiles.Bolas;
import com.postmodern.postmoderndungeon.items.weapon.missiles.FishingSpear;
import com.postmodern.postmoderndungeon.items.weapon.missiles.ForceCube;
import com.postmodern.postmoderndungeon.items.weapon.missiles.HeavyBoomerang;
import com.postmodern.postmoderndungeon.items.weapon.missiles.Javelin;
import com.postmodern.postmoderndungeon.items.weapon.missiles.Kunai;
import com.postmodern.postmoderndungeon.items.weapon.missiles.MissileWeapon;
import com.postmodern.postmoderndungeon.items.weapon.missiles.Shuriken;
import com.postmodern.postmoderndungeon.items.weapon.missiles.ThrowingClub;
import com.postmodern.postmoderndungeon.items.weapon.missiles.ThrowingHammer;
import com.postmodern.postmoderndungeon.items.weapon.missiles.ThrowingKnife;
import com.postmodern.postmoderndungeon.items.weapon.missiles.ThrowingSpear;
import com.postmodern.postmoderndungeon.items.weapon.missiles.ThrowingStone;
import com.postmodern.postmoderndungeon.items.weapon.missiles.Tomahawk;
import com.postmodern.postmoderndungeon.items.weapon.missiles.Trident;
import com.postmodern.postmoderndungeon.plants.Blindweed;
import com.postmodern.postmoderndungeon.plants.Dreamfoil;
import com.postmodern.postmoderndungeon.plants.Earthroot;
import com.postmodern.postmoderndungeon.plants.Fadeleaf;
import com.postmodern.postmoderndungeon.plants.Firebloom;
import com.postmodern.postmoderndungeon.plants.Icecap;
import com.postmodern.postmoderndungeon.plants.Plant;
import com.postmodern.postmoderndungeon.plants.Rotberry;
import com.postmodern.postmoderndungeon.plants.Sorrowmoss;
import com.postmodern.postmoderndungeon.plants.Starflower;
import com.postmodern.postmoderndungeon.plants.Stormvine;
import com.postmodern.postmoderndungeon.plants.Sungrass;
import com.postmodern.postmoderndungeon.plants.Swiftthistle;
import com.watabou.utils.Bundle;
import com.watabou.utils.GameMath;
import com.watabou.utils.Random;
import com.watabou.utils.Reflection;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Generator {

	public enum Category {
		WEAPON	( 2, 2, MeleeWeapon.class),
		WEP_T1	( 0, 0, MeleeWeapon.class),
		WEP_T2	( 0, 0, MeleeWeapon.class),
		WEP_T3	( 0, 0, MeleeWeapon.class),
		WEP_T4	( 0, 0, MeleeWeapon.class),
		WEP_T5	( 0, 0, MeleeWeapon.class),
		
		ARMOR	( 2, 1, Armor.class ),
		
		MISSILE ( 1, 2, MissileWeapon.class ),
		MIS_T1  ( 0, 0, MissileWeapon.class ),
		MIS_T2  ( 0, 0, MissileWeapon.class ),
		MIS_T3  ( 0, 0, MissileWeapon.class ),
		MIS_T4  ( 0, 0, MissileWeapon.class ),
		MIS_T5  ( 0, 0, MissileWeapon.class ),
		
		WAND	( 1, 1, Wand.class ),
		RING	( 1, 0, Ring.class ),
		ARTIFACT( 0, 1, Artifact.class),
		
		FOOD	( 0, 0, Food.class ),
		
		POTION	( 8, 8, Potion.class ),
		SEED	( 1, 1, Plant.Seed.class ),
		
		SCROLL	( 8, 8, Scroll.class ),
		STONE   ( 1, 1, Runestone.class),
		
		GOLD	( 10, 10,   Gold.class );
		
		public Class<?>[] classes;

		//some item types use a deck-based system, where the probs decrement as items are picked
		// until they are all 0, and then they reset. Those generator classes should define
		// defaultProbs. If defaultProbs is null then a deck system isn't used.
		//Artifacts in particular don't reset, no duplicates!
		public float[] probs;
		public float[] defaultProbs = null;

		//game has two decks of 35 items for overall category probs
		//one deck has a ring and extra armor, the other has an artifact and extra thrown weapon
		public float firstProb;
		public float secondProb;
		public Class<? extends Item> superClass;
		
		private Category( float firstProb, float secondProb, Class<? extends Item> superClass ) {
			this.firstProb = firstProb;
			this.secondProb = secondProb;
			this.superClass = superClass;
		}
		
		public static int order( Item item ) {
			for (int i=0; i < values().length; i++) {
				if (values()[i].superClass.isInstance( item )) {
					return i;
				}
			}

			//items without a category-defined order are sorted based on the spritesheet
			return Short.MAX_VALUE+item.image();
		}

		static {
			GOLD.classes = new Class<?>[]{
					Gold.class };
			GOLD.probs = new float[]{ 1 };
			
			POTION.classes = new Class<?>[]{
					PotionOfStrength.class, //2 drop every chapter, see Dungeon.posNeeded()
					PotionOfHealing.class,
					PotionOfMindVision.class,
					PotionOfFrost.class,
					PotionOfLiquidFlame.class,
					PotionOfToxicGas.class,
					PotionOfHaste.class,
					PotionOfInvisibility.class,
					PotionOfLevitation.class,
					PotionOfParalyticGas.class,
					PotionOfPurity.class,
					PotionOfExperience.class};
			POTION.defaultProbs = new float[]{ 0, 6, 4, 3, 3, 3, 2, 2, 2, 2, 2, 1 };
			POTION.probs = POTION.defaultProbs.clone();
			
			SEED.classes = new Class<?>[]{
					Rotberry.Seed.class, //quest item
					Sungrass.Seed.class,
					Fadeleaf.Seed.class,
					Icecap.Seed.class,
					Firebloom.Seed.class,
					Sorrowmoss.Seed.class,
					Swiftthistle.Seed.class,
					Blindweed.Seed.class,
					Stormvine.Seed.class,
					Earthroot.Seed.class,
					Dreamfoil.Seed.class,
					Starflower.Seed.class};
			SEED.defaultProbs = new float[]{ 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 2 };
			SEED.probs = SEED.defaultProbs.clone();
			
			SCROLL.classes = new Class<?>[]{
					ScrollOfUpgrade.class, //3 drop every chapter, see Dungeon.souNeeded()
					ScrollOfIdentify.class,
					ScrollOfRemoveCurse.class,
					ScrollOfMirrorImage.class,
					ScrollOfRecharging.class,
					ScrollOfTeleportation.class,
					ScrollOfLullaby.class,
					ScrollOfMagicMapping.class,
					ScrollOfRage.class,
					ScrollOfRetribution.class,
					ScrollOfTerror.class,
					ScrollOfTransmutation.class
			};
			SCROLL.defaultProbs = new float[]{ 0, 6, 4, 3, 3, 3, 2, 2, 2, 2, 2, 1 };
			SCROLL.probs = SCROLL.defaultProbs.clone();
			
			STONE.classes = new Class<?>[]{
					StoneOfEnchantment.class,   //1 is guaranteed to drop on floors 6-19
					StoneOfIntuition.class,     //1 additional stone is also dropped on floors 1-3
					StoneOfDisarming.class,
					StoneOfFlock.class,
					StoneOfShock.class,
					StoneOfBlink.class,
					StoneOfDeepSleep.class,
					StoneOfClairvoyance.class,
					StoneOfAggression.class,
					StoneOfBlast.class,
					StoneOfFear.class,
					StoneOfAugmentation.class  //1 is sold in each shop
			};
			STONE.defaultProbs = new float[]{ 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 };
			STONE.probs = STONE.defaultProbs.clone();

			WAND.classes = new Class<?>[]{
					WandOfMagicMissile.class,
					WandOfLightning.class,
					WandOfDisintegration.class,
					WandOfFireblast.class,
					WandOfCorrosion.class,
					WandOfBlastWave.class,
					WandOfLivingEarth.class,
					WandOfFrost.class,
					WandOfPrismaticLight.class,
					WandOfWarding.class,
					WandOfTransfusion.class,
					WandOfCorruption.class,
					WandOfRegrowth.class };
			WAND.probs = new float[]{ 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3 };
			
			//see generator.randomWeapon
			WEAPON.classes = new Class<?>[]{};
			WEAPON.probs = new float[]{};
			
			WEP_T1.classes = new Class<?>[]{
					WornShortsword.class,
					Gloves.class,
					Dagger.class,
					MagesStaff.class
			};
			WEP_T1.probs = new float[]{ 1, 1, 1, 0 };
			
			WEP_T2.classes = new Class<?>[]{
					Shortsword.class,
					HandAxe.class,
					Spear.class,
					Quarterstaff.class,
					Dirk.class
			};
			WEP_T2.probs = new float[]{ 6, 5, 5, 4, 4 };
			
			WEP_T3.classes = new Class<?>[]{
					Sword.class,
					Mace.class,
					Scimitar.class,
					RoundShield.class,
					Sai.class,
					Whip.class
			};
			WEP_T3.probs = new float[]{ 6, 5, 5, 4, 4, 4 };
			
			WEP_T4.classes = new Class<?>[]{
					Longsword.class,
					BattleAxe.class,
					Flail.class,
					RunicBlade.class,
					AssassinsBlade.class,
					Crossbow.class
			};
			WEP_T4.probs = new float[]{ 6, 5, 5, 4, 4, 4 };
			
			WEP_T5.classes = new Class<?>[]{
					Greatsword.class,
					WarHammer.class,
					Glaive.class,
					Greataxe.class,
					Greatshield.class,
					Gauntlet.class
			};
			WEP_T5.probs = new float[]{ 6, 5, 5, 4, 4, 4 };
			
			//see Generator.randomArmor
			ARMOR.classes = new Class<?>[]{
					ClothArmor.class,
					LeatherArmor.class,
					MailArmor.class,
					ScaleArmor.class,
					PlateArmor.class };
			ARMOR.probs = new float[]{ 0, 0, 0, 0, 0 };
			
			//see Generator.randomMissile
			MISSILE.classes = new Class<?>[]{};
			MISSILE.probs = new float[]{};
			
			MIS_T1.classes = new Class<?>[]{
					ThrowingStone.class,
					ThrowingKnife.class
			};
			MIS_T1.probs = new float[]{ 6, 5 };
			
			MIS_T2.classes = new Class<?>[]{
					FishingSpear.class,
					ThrowingClub.class,
					Shuriken.class
			};
			MIS_T2.probs = new float[]{ 6, 5, 4 };
			
			MIS_T3.classes = new Class<?>[]{
					ThrowingSpear.class,
					Kunai.class,
					Bolas.class
			};
			MIS_T3.probs = new float[]{ 6, 5, 4 };
			
			MIS_T4.classes = new Class<?>[]{
					Javelin.class,
					Tomahawk.class,
					HeavyBoomerang.class
			};
			MIS_T4.probs = new float[]{ 6, 5, 4 };
			
			MIS_T5.classes = new Class<?>[]{
					Trident.class,
					ThrowingHammer.class,
					ForceCube.class
			};
			MIS_T5.probs = new float[]{ 6, 5, 4 };
			
			FOOD.classes = new Class<?>[]{
					Food.class,
					Pasty.class,
					MysteryMeat.class };
			FOOD.probs = new float[]{ 4, 1, 0 };
			
			RING.classes = new Class<?>[]{
					RingOfAccuracy.class,
					RingOfEvasion.class,
					RingOfElements.class,
					RingOfForce.class,
					RingOfFuror.class,
					RingOfHaste.class,
					RingOfEnergy.class,
					RingOfMight.class,
					RingOfSharpshooting.class,
					RingOfTenacity.class,
					RingOfWealth.class};
			RING.probs = new float[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
			
			ARTIFACT.classes = new Class<?>[]{
					CapeOfThorns.class,
					ChaliceOfBlood.class,
					CloakOfShadows.class,
					HornOfPlenty.class,
					MasterThievesArmband.class,
					SandalsOfNature.class,
					TalismanOfForesight.class,
					TimekeepersHourglass.class,
					UnstableSpellbook.class,
					AlchemistsToolkit.class,
					DriedRose.class,
					LloydsBeacon.class,
					EtherealChains.class
			};
			ARTIFACT.defaultProbs = new float[]{ 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1};
			ARTIFACT.probs = ARTIFACT.defaultProbs.clone();
		}
	}

	private static final float[][] floorSetTierProbs = new float[][] {
			{0, 75, 20,  4,  1},
			{0, 25, 50, 20,  5},
			{0,  0, 40, 50, 10},
			{0,  0, 20, 40, 40},
			{0,  0,  0, 20, 80}
	};

	private static boolean usingFirstDeck = false;
	private static HashMap<Category,Float> categoryProbs = new LinkedHashMap<>();

	public static void fullReset() {
		usingFirstDeck = Random.Int(2) == 0;
		generalReset();
		for (Category cat : Category.values()) {
			reset(cat);
		}
	}

	public static void generalReset(){
		for (Category cat : Category.values()) {
			categoryProbs.put( cat, usingFirstDeck ? cat.firstProb : cat.secondProb );
		}
	}

	public static void reset(Category cat){
		if (cat.defaultProbs != null) cat.probs = cat.defaultProbs.clone();
	}
	
	public static Item random() {
		Category cat = Random.chances( categoryProbs );
		if (cat == null){
			usingFirstDeck = !usingFirstDeck;
			generalReset();
			cat = Random.chances( categoryProbs );
		}
		categoryProbs.put( cat, categoryProbs.get( cat ) - 1);
		return random( cat );
	}
	
	public static Item random( Category cat ) {
		switch (cat) {
			case ARMOR:
				return randomArmor();
			case WEAPON:
				return randomWeapon();
			case MISSILE:
				return randomMissile();
			case ARTIFACT:
				Item item = randomArtifact();
				//if we're out of artifacts, return a ring instead.
				return item != null ? item : random(Category.RING);
			default:
				int i = Random.chances(cat.probs);
				if (i == -1) {
					reset(cat);
					i = Random.chances(cat.probs);
				}
				if (cat.defaultProbs != null) cat.probs[i]--;
				return ((Item) Reflection.newInstance(cat.classes[i])).random();
		}
	}

	//overrides any deck systems and always uses default probs
	public static Item randomUsingDefaults( Category cat ){
		if (cat.defaultProbs == null) {
			return random(cat); //currently covers weapons/armor/missiles
		} else {
			return ((Item) Reflection.newInstance(cat.classes[Random.chances(cat.defaultProbs)])).random();
		}
	}
	
	public static Item random( Class<? extends Item> cl ) {
		return Reflection.newInstance(cl).random();
	}

	public static Armor randomArmor(){
		return randomArmor(Dungeon.depth / 5);
	}
	
	public static Armor randomArmor(int floorSet) {

		floorSet = (int)GameMath.gate(0, floorSet, floorSetTierProbs.length-1);
		
		Armor a = (Armor)Reflection.newInstance(Category.ARMOR.classes[Random.chances(floorSetTierProbs[floorSet])]);
		a.random();
		return a;
	}

	public static final Category[] wepTiers = new Category[]{
			Category.WEP_T1,
			Category.WEP_T2,
			Category.WEP_T3,
			Category.WEP_T4,
			Category.WEP_T5
	};

	public static MeleeWeapon randomWeapon(){
		return randomWeapon(Dungeon.depth / 5);
	}
	
	public static MeleeWeapon randomWeapon(int floorSet) {

		floorSet = (int)GameMath.gate(0, floorSet, floorSetTierProbs.length-1);
		
		Category c = wepTiers[Random.chances(floorSetTierProbs[floorSet])];
		MeleeWeapon w = (MeleeWeapon)Reflection.newInstance(c.classes[Random.chances(c.probs)]);
		w.random();
		return w;
	}
	
	public static final Category[] misTiers = new Category[]{
			Category.MIS_T1,
			Category.MIS_T2,
			Category.MIS_T3,
			Category.MIS_T4,
			Category.MIS_T5
	};
	
	public static MissileWeapon randomMissile(){
		return randomMissile(Dungeon.depth / 5);
	}
	
	public static MissileWeapon randomMissile(int floorSet) {
		
		floorSet = (int)GameMath.gate(0, floorSet, floorSetTierProbs.length-1);
		
		Category c = misTiers[Random.chances(floorSetTierProbs[floorSet])];
		MissileWeapon w = (MissileWeapon)Reflection.newInstance(c.classes[Random.chances(c.probs)]);
		w.random();
		return w;
	}

	//enforces uniqueness of artifacts throughout a run.
	public static Artifact randomArtifact() {

		Category cat = Category.ARTIFACT;
		int i = Random.chances( cat.probs );

		//if no artifacts are left, return null
		if (i == -1){
			return null;
		}

		cat.probs[i]--;
		return (Artifact) Reflection.newInstance((Class<? extends Artifact>) cat.classes[i]).random();

	}

	public static boolean removeArtifact(Class<?extends Artifact> artifact) {
		Category cat = Category.ARTIFACT;
		for (int i = 0; i < cat.classes.length; i++){
			if (cat.classes[i].equals(artifact) && cat.probs[i] > 0) {
				cat.probs[i] = 0;
				return true;
			}
		}
		return false;
	}

	private static final String FIRST_DECK = "first_deck";
	private static final String GENERAL_PROBS = "general_probs";
	private static final String CATEGORY_PROBS = "_probs";
	
	public static void storeInBundle(Bundle bundle) {
		bundle.put(FIRST_DECK, usingFirstDeck);

		Float[] genProbs = categoryProbs.values().toArray(new Float[0]);
		float[] storeProbs = new float[genProbs.length];
		for (int i = 0; i < storeProbs.length; i++){
			storeProbs[i] = genProbs[i];
		}
		bundle.put( GENERAL_PROBS, storeProbs);

		for (Category cat : Category.values()){
			if (cat.defaultProbs == null) continue;
			boolean needsStore = false;
			for (int i = 0; i < cat.probs.length; i++){
				if (cat.probs[i] != cat.defaultProbs[i]){
					needsStore = true;
					break;
				}
			}

			if (needsStore){
				bundle.put(cat.name().toLowerCase() + CATEGORY_PROBS, cat.probs);
			}
		}
	}

	public static void restoreFromBundle(Bundle bundle) {
		fullReset();

		usingFirstDeck = bundle.getBoolean(FIRST_DECK);

		if (bundle.contains(GENERAL_PROBS)){
			float[] probs = bundle.getFloatArray(GENERAL_PROBS);
			for (int i = 0; i < probs.length; i++){
				categoryProbs.put(Category.values()[i], probs[i]);
			}
		}

		for (Category cat : Category.values()){
			if (bundle.contains(cat.name().toLowerCase() + CATEGORY_PROBS)){
				float[] probs = bundle.getFloatArray(cat.name().toLowerCase() + CATEGORY_PROBS);
				if (cat.defaultProbs != null && probs.length == cat.defaultProbs.length){
					cat.probs = probs;
				}
			}
		}
		
	}
}
