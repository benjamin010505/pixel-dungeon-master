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

import com.postmodern.postmoderndungeon.Assets;
import com.postmodern.postmoderndungeon.Dungeon;
import com.postmodern.postmoderndungeon.actors.hero.Hero;
import com.postmodern.postmoderndungeon.actors.mobs.npcs.Shopkeeper;
import com.postmodern.postmoderndungeon.items.Item;
import com.postmodern.postmoderndungeon.messages.Messages;
import com.postmodern.postmoderndungeon.scenes.GameScene;
import com.postmodern.postmoderndungeon.sprites.ItemSprite;
import com.postmodern.postmoderndungeon.sprites.ItemSpriteSheet;
import com.postmodern.postmoderndungeon.ui.RedButton;
import com.postmodern.postmoderndungeon.windows.WndBag;
import com.postmodern.postmoderndungeon.windows.WndEnergizeItem;
import com.postmodern.postmoderndungeon.windows.WndInfoItem;
import com.postmodern.postmoderndungeon.windows.WndTradeItem;
import com.watabou.noosa.audio.Sample;

public class Alchemize extends Spell {
	
	{
		image = ItemSpriteSheet.ALCHEMIZE;
	}
	
	@Override
	protected void onCast(Hero hero) {
		GameScene.selectItem( itemSelector );
	}
	
	@Override
	public int value() {
		//prices of ingredients, divided by output quantity
		return Math.round(quantity * (40 / 8f));
	}

	//TODO also allow alchemical catalyst? Or save that for an elixir/brew?
	public static class Recipe extends com.postmodern.postmoderndungeon.items.Recipe.SimpleRecipe {

		{
			inputs =  new Class[]{ArcaneCatalyst.class};
			inQuantity = new int[]{1};
			
			cost = 3;
			
			output = Alchemize.class;
			outQuantity = 8;
		}
		
	}

	private static WndBag.ItemSelector itemSelector = new WndBag.ItemSelector() {
		@Override
		public String textPrompt() {
			return Messages.get(Alchemize.class, "prompt");
		}

		@Override
		public boolean itemSelectable(Item item) {
			return !(item instanceof Alchemize)
					&& (Shopkeeper.canSell(item) || item.energyVal() > 0);
		}

		@Override
		public void onSelect( Item item ) {
			if (item != null) {
				WndBag parentWnd = GameScene.selectItem( itemSelector );
				GameScene.show( new WndAlchemizeItem( item, parentWnd ) );
			}
		}
	};


	public static class WndAlchemizeItem extends WndInfoItem {

		private static final float GAP		= 2;
		private static final int BTN_HEIGHT	= 18;

		private WndBag owner;

		public WndAlchemizeItem(Item item, WndBag owner) {
			super(item);

			this.owner = owner;

			float pos = height;

			if (Shopkeeper.canSell(item)) {
				if (item.quantity() == 1) {

					RedButton btnSell = new RedButton(Messages.get(this, "sell", item.value())) {
						@Override
						protected void onClick() {
							WndTradeItem.sell(item);
							consumeAlchemize();
							hide();
						}
					};
					btnSell.setRect(0, pos + GAP, width, BTN_HEIGHT);
					btnSell.icon(new ItemSprite(ItemSpriteSheet.GOLD));
					add(btnSell);

					pos = btnSell.bottom();

				} else {

					int priceAll = item.value();
					RedButton btnSell1 = new RedButton(Messages.get(this, "sell_1", priceAll / item.quantity())) {
						@Override
						protected void onClick() {
							WndTradeItem.sellOne(item);
							consumeAlchemize();
							hide();
						}
					};
					btnSell1.setRect(0, pos + GAP, width, BTN_HEIGHT);
					btnSell1.icon(new ItemSprite(ItemSpriteSheet.GOLD));
					add(btnSell1);
					RedButton btnSellAll = new RedButton(Messages.get(this, "sell_all", priceAll)) {
						@Override
						protected void onClick() {
							WndTradeItem.sell(item);
							consumeAlchemize();
							hide();
						}
					};
					btnSellAll.setRect(0, btnSell1.bottom() + 1, width, BTN_HEIGHT);
					btnSellAll.icon(new ItemSprite(ItemSpriteSheet.GOLD));
					add(btnSellAll);

					pos = btnSellAll.bottom();

				}
			}

			if (item.energyVal() > 0) {
				if (item.quantity() == 1) {

					RedButton btnEnergize = new RedButton(Messages.get(this, "energize", item.energyVal())) {
						@Override
						protected void onClick() {
							WndEnergizeItem.energize(item);
							consumeAlchemize();
							hide();
						}
					};
					btnEnergize.setRect(0, pos + GAP, width, BTN_HEIGHT);
					btnEnergize.icon(new ItemSprite(ItemSpriteSheet.ENERGY));
					add(btnEnergize);

					pos = btnEnergize.bottom();

				} else {

					int energyAll = item.energyVal();
					RedButton btnEnergize1 = new RedButton(Messages.get(this, "energize_1", energyAll / item.quantity())) {
						@Override
						protected void onClick() {
							WndEnergizeItem.energizeOne(item);
							consumeAlchemize();
							hide();
						}
					};
					btnEnergize1.setRect(0, pos + GAP, width, BTN_HEIGHT);
					btnEnergize1.icon(new ItemSprite(ItemSpriteSheet.ENERGY));
					add(btnEnergize1);
					RedButton btnEnergizeAll = new RedButton(Messages.get(this, "energize_all", energyAll)) {
						@Override
						protected void onClick() {
							WndEnergizeItem.energize(item);
							consumeAlchemize();
							hide();
						}
					};
					btnEnergizeAll.setRect(0, btnEnergize1.bottom() + 1, width, BTN_HEIGHT);
					btnEnergizeAll.icon(new ItemSprite(ItemSpriteSheet.ENERGY));
					add(btnEnergizeAll);

					pos = btnEnergizeAll.bottom();

				}
			}

			resize( width, (int)pos );

		}

		private void consumeAlchemize(){
			Sample.INSTANCE.play(Assets.Sounds.TELEPORT);
			if (curItem.quantity() <= 1){
				curItem.detachAll(Dungeon.hero.belongings.backpack);
				owner.hide();
				owner = null;
			} else {
				curItem.detach(Dungeon.hero.belongings.backpack);
			}
		}

		@Override
		public void hide() {

			super.hide();

			if (owner != null) {
				owner.hide();
				GameScene.selectItem(itemSelector);
			}
		}
	}
}
