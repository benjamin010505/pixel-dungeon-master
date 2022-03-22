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

package com.postmodern.postmoderndungeon;

import com.postmodern.postmoderndungeon.items.scrolls.exotic.ScrollOfMetamorphosis;
import com.postmodern.postmoderndungeon.scenes.GameScene;
import com.postmodern.postmoderndungeon.scenes.PixelScene;
import com.postmodern.postmoderndungeon.scenes.TitleScene;
import com.postmodern.postmoderndungeon.scenes.WelcomeScene;
import com.watabou.noosa.Game;
import com.watabou.noosa.audio.Music;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.DeviceCompat;
import com.watabou.utils.PlatformSupport;

public class ShatteredPixelDungeon extends Game {

	//variable constants for specific older versions of shattered, used for data conversion
	//versions older than v0.9.0b are no longer supported, and data from them is ignored
	public static final int v0_9_0b  = 489;
	public static final int v0_9_1d  = 511;
	public static final int v0_9_2b  = 531;
	public static final int v0_9_3c  = 557; //557 on iOS, 554 on other platforms

	public static final int v1_0_3   = 574;
	public static final int v1_1_0   = 583;
	
	public ShatteredPixelDungeon(PlatformSupport platform ) {
		super( sceneClass == null ? WelcomeScene.class : sceneClass, platform );
	//	super( sceneClass == null ? WelcomeScene.class : sceneClass, platform );
		//v1.1.0
		com.watabou.utils.Bundle.addAlias(
				com.postmodern.postmoderndungeon.items.scrolls.exotic.ScrollOfDread.class,
				"com.postmodern.postmoderndungeon.items.scrolls.exotic.ScrollOfPetrification" );
		com.watabou.utils.Bundle.addAlias(
				com.postmodern.postmoderndungeon.items.scrolls.exotic.ScrollOfSirensSong.class,
				"com.postmodern.postmoderndungeon.items.scrolls.exotic.ScrollOfAffection" );
		com.watabou.utils.Bundle.addAlias(
				com.postmodern.postmoderndungeon.items.scrolls.exotic.ScrollOfChallenge.class,
				"com.postmodern.postmoderndungeon.items.scrolls.exotic.ScrollOfConfusion" );
		com.watabou.utils.Bundle.addAlias(
				com.postmodern.postmoderndungeon.items.potions.exotic.PotionOfDivineInspiration.class,
				"com.postmodern.postmoderndungeon.items.potions.exotic.PotionOfHolyFuror" );
		com.watabou.utils.Bundle.addAlias(
				com.postmodern.postmoderndungeon.items.potions.exotic.PotionOfMastery.class,
				"com.postmodern.postmoderndungeon.items.potions.exotic.PotionOfAdrenalineSurge" );
		com.watabou.utils.Bundle.addAlias(
				ScrollOfMetamorphosis.class,
				"com.postmodern.postmoderndungeon.items.scrolls.exotic.ScrollOfPolymorph" );

		//v1.0.0
		com.watabou.utils.Bundle.addAlias(
				com.postmodern.postmoderndungeon.items.stones.StoneOfFear.class,
				"com.postmodern.postmoderndungeon.items.stones.StoneOfAffection" );
		com.watabou.utils.Bundle.addAlias(
				com.postmodern.postmoderndungeon.items.stones.StoneOfDeepSleep.class,
				"com.postmodern.postmoderndungeon.items.stones.StoneOfDeepenedSleep" );

		//v0.9.3
		com.watabou.utils.Bundle.addAlias(
				com.postmodern.postmoderndungeon.actors.mobs.Tengu.class,
				"com.postmodern.postmoderndungeon.actors.mobs.NewTengu" );
		com.watabou.utils.Bundle.addAlias(
				com.postmodern.postmoderndungeon.levels.PrisonBossLevel.class,
				"com.postmodern.postmoderndungeon.levels.NewPrisonBossLevel" );
		com.watabou.utils.Bundle.addAlias(
				com.postmodern.postmoderndungeon.levels.PrisonBossLevel.ExitVisual.class,
				"com.postmodern.postmoderndungeon.levels.NewPrisonBossLevel$exitVisual" );
		com.watabou.utils.Bundle.addAlias(
				com.postmodern.postmoderndungeon.levels.PrisonBossLevel.ExitVisualWalls.class,
				"com.postmodern.postmoderndungeon.levels.NewPrisonBossLevel$exitVisualWalls" );
		com.watabou.utils.Bundle.addAlias(
				com.postmodern.postmoderndungeon.actors.mobs.DM300.class,
				"com.postmodern.postmoderndungeon.actors.mobs.NewDM300" );
		com.watabou.utils.Bundle.addAlias(
				com.postmodern.postmoderndungeon.levels.CavesBossLevel.class,
				"com.postmodern.postmoderndungeon.levels.NewCavesBossLevel" );
		com.watabou.utils.Bundle.addAlias(
				com.postmodern.postmoderndungeon.levels.CavesBossLevel.PylonEnergy.class,
				"com.postmodern.postmoderndungeon.levels.NewCavesBossLevel$PylonEnergy" );
		com.watabou.utils.Bundle.addAlias(
				com.postmodern.postmoderndungeon.levels.CavesBossLevel.ArenaVisuals.class,
				"com.postmodern.postmoderndungeon.levels.NewCavesBossLevel$ArenaVisuals" );
		com.watabou.utils.Bundle.addAlias(
				com.postmodern.postmoderndungeon.levels.CavesBossLevel.CityEntrance.class,
				"com.postmodern.postmoderndungeon.levels.NewCavesBossLevel$CityEntrance" );
		com.watabou.utils.Bundle.addAlias(
				com.postmodern.postmoderndungeon.levels.CavesBossLevel.EntranceOverhang.class,
				"com.postmodern.postmoderndungeon.levels.NewCavesBossLevel$EntranceOverhang" );
		com.watabou.utils.Bundle.addAlias(
				com.postmodern.postmoderndungeon.levels.CityBossLevel.class,
				"com.postmodern.postmoderndungeon.levels.NewCityBossLevel" );
		com.watabou.utils.Bundle.addAlias(
				com.postmodern.postmoderndungeon.levels.CityBossLevel.CustomGroundVisuals.class,
				"com.postmodern.postmoderndungeon.levels.NewCityBossLevel$CustomGroundVisuals" );
		com.watabou.utils.Bundle.addAlias(
				com.postmodern.postmoderndungeon.levels.CityBossLevel.CustomWallVisuals.class,
				"com.postmodern.postmoderndungeon.levels.NewCityBossLevel$CustomWallVisuals" );
		com.watabou.utils.Bundle.addAlias(
				com.postmodern.postmoderndungeon.levels.HallsBossLevel.class,
				"com.postmodern.postmoderndungeon.levels.NewHallsBossLevel" );
		com.watabou.utils.Bundle.addAlias(
				com.postmodern.postmoderndungeon.levels.HallsBossLevel.CenterPieceVisuals.class,
				"com.postmodern.postmoderndungeon.levels.NewHallsBossLevel$CenterPieceWalls" );
		com.watabou.utils.Bundle.addAlias(
				com.postmodern.postmoderndungeon.levels.HallsBossLevel.CenterPieceWalls.class,
				"com.postmodern.postmoderndungeon.levels.NewHallsBossLevel$CenterPieceWalls" );
		com.watabou.utils.Bundle.addAlias(
				com.postmodern.postmoderndungeon.items.Waterskin.class,
				"com.postmodern.postmoderndungeon.items.DewVial" );
		com.watabou.utils.Bundle.addAlias(
				com.postmodern.postmoderndungeon.items.TengusMask.class,
				"com.postmodern.postmoderndungeon.items.TomeOfMastery" );
		com.watabou.utils.Bundle.addAlias(
				com.postmodern.postmoderndungeon.items.KingsCrown.class,
				"com.postmodern.postmoderndungeon.items.ArmorKit" );
		
	}
	
	@Override
	public void create() {
		super.create();

		updateSystemUI();
		SPDAction.loadBindings();
		
		Music.INSTANCE.enable( SPDSettings.music() );
		Music.INSTANCE.volume( SPDSettings.musicVol()*SPDSettings.musicVol()/100f );
		Sample.INSTANCE.enable( SPDSettings.soundFx() );
		Sample.INSTANCE.volume( SPDSettings.SFXVol()*SPDSettings.SFXVol()/100f );

		Sample.INSTANCE.load( Assets.Sounds.all );
		
	}

	@Override
	public void finish() {
		if (!DeviceCompat.isiOS()) {
			super.finish();
		} else {
			//can't exit on iOS (Apple guidelines), so just go to title screen
			switchScene(TitleScene.class);
		}
	}

	public static void switchNoFade(Class<? extends PixelScene> c){
		switchNoFade(c, null);
	}

	public static void switchNoFade(Class<? extends PixelScene> c, SceneChangeCallback callback) {
		PixelScene.noFade = true;
		switchScene( c, callback );
	}
	
	public static void seamlessResetScene(SceneChangeCallback callback) {
		if (scene() instanceof PixelScene){
			((PixelScene) scene()).saveWindows();
			switchNoFade((Class<? extends PixelScene>) sceneClass, callback );
		} else {
			resetScene();
		}
	}
	
	public static void seamlessResetScene(){
		seamlessResetScene(null);
	}
	
	@Override
	protected void switchScene() {
		super.switchScene();
		if (scene instanceof PixelScene){
			((PixelScene) scene).restoreWindows();
		}
	}
	
	@Override
	public void resize( int width, int height ) {
		if (width == 0 || height == 0){
			return;
		}

		if (scene instanceof PixelScene &&
				(height != Game.height || width != Game.width)) {
			PixelScene.noFade = true;
			((PixelScene) scene).saveWindows();
		}

		super.resize( width, height );

		updateDisplaySize();

	}
	
	@Override
	public void destroy(){
		super.destroy();
		GameScene.endActorThread();
	}
	
	public void updateDisplaySize(){
		platform.updateDisplaySize();
	}

	public static void updateSystemUI() {
		platform.updateSystemUI();
	}
}