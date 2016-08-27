# TextFuzion
文字大乱斗
##角色 Part
#####owner： String 拥有此角色的用户ID
#####objectId ：创建角色产生的随机ID
#####name: String 角色的名称
#####type:int 职业 （0：无职业，1：战士。2：法师，3：游侠）
#####Lv:int 角色的等级（高于角色等级无法使用）
#####HP :int 生命值 角色的总生命值
#####MP :int 魔法值 角色的总魔法值
#####CHP :int 当前生命值 角色的当前生命值
#####CMP :int 当前魔法值 角色的当前魔法值
#####ATK：int 角色的总攻击力
#####DEF：int 角色的总防御力
#####baseATK：int 角色的基础攻击力
#####baseDEF：int 角色的基础防御力
#####INT ：int  智力  //决定魔法值/魔法伤害
#####AGI:：int 敏捷  //决定攻击速度/暴击/闪避
#####STR ：int 力量  //决定生命值/物理伤害
#####LUC :int 运气  //决定打造升级装备成功概率
#####SP：int 技能点 
 
####创建代码示例：






##武器 Equip
#####owner： String 拥有此物品的角色ID  
#####objectId ：创建物品产生的随机ID
#####name: String 武器名称
#####Lv:int 武器等级（高于角色等级无法使用）
#####type：int 武器类型 （0：无法使用 ，1：正常使用，2：条件使用）
#####condition：int 佩戴条件（当type=2时 需满足佩戴条件）
#####ATK：int 攻击力（武器伤害）
#####DEF：int 防御力
#####HP :int 生命值 武器提供的生命值
#####MP :int 魔法值 武器提供的魔法值
#####SE:int 物品特效 武器产生的特殊效果
  
####创建代码示例：
    AVObject equip = new AVObject("Equip");
    equip.put("owner", part);
    equip.put("name", "新手剑");
    equip.put("LV", 1);
    equip.put("type", 1);
    equip.put("condition", 0);
    equip.put("ATK", 12);
    equip.put("DEF", 0);
    equip.put("HP", 0);
    equip.put("MP", 0);
    equip.put("SE", 0);
    equip.saveInBackground();


##盔甲 Armor 
#####owner： String 拥有此物品的角色ID
#####objectId ：创建物品产生的随机ID
#####name: String 盔甲名称
#####Lv:int 盔甲等级（高于角色等级无法使用）
#####type：int 盔甲类型 （0：无法使用 ，1：正常使用，2：条件使用）
#####condition：int 佩戴条件（当type=2时 需满足佩戴条件）
#####ATK：int 攻击力（盔甲提供伤害 ps:盔甲通常情况下不增加伤害）
#####DEF：int 防御力 （盔甲提供护甲）
#####HP :int 生命值 盔甲提供的生命值
#####MP :int 魔法值 盔甲提供的魔法值
#####SE:int 物品特效 盔甲产生的特殊效果

####创建代码示例：
    AVObject armor = new AVObject("Armor");
    armor.put("owner", part);
    armor.put("name", "新手剑");
    armor.put("LV", 500);
    armor.put("type", 1);
    armor.put("condition", 2566);
    armor.put("ATK", 0);
    armor.put("DEF", 666);
    armor.put("HP", 2000);
    armor.put("MP", 0);
    armor.put("SE", 33);
    armor.saveInBackground();


##物品 Items
#####objectId ：创建物品产生的随机ID
#####owner： String 拥有此物品的角色ID
#####name: String 物品名称
#####type：int 物品类型 （0：无法使用 ，1：战斗物品，2：非战斗物品，3：通用物品）
#####Lv:int 物品等级（高于角色等级无法使用）
#####condition：int 使用条件（当type=2时 需满足使用条件）
#####HP :int 生命值 物品提供的生命值 //影响当前生命值
#####MP :int 魔法值 物品提供的魔法值  //影响当前魔法值
#####time: int 物品效果持续时间

####创建代码示例：
    AVObject items = new AVObject("Items");
    items.put("owner", part);
    items.put("name", "生命药剂");
    items.put("LV", 1);
    items.put("type", 3);
    items.put("condition", 0);
    items.put("HP", 100);
    items.put("MP", 0);
    items.put("time", 0);
    items.saveInBackground();
	
####查询代码示例
    new AVQuery<>("Items").whereEqualTo("owner", part)
                .findInBackground(new FindCallback<AVObject>() {
                    @Override
                    public void done(List<AVObject> list, AVException e) {
                        for (AVObject item : list) {
                            Logger.e(e == null ? item.getString("name") : e.getMessage());
                        }
                    }
                });




				
## 效果 SE
#####objectId ：创建特效产生的随机ID
#####itemId： String 拥有此特效的物品ID
#####skillId: String 拥有此特效的技能ID
#####name: String 特效名称
#####SE:int 反馈效果  特效的核心实现逻辑由此值控制
#####mode：int 特效模式 （0：无法触发 ，1：永久特效，2：持续特效，3：条件触发特效）
#####type：int 特效种类 （0:无分类，1:物品特效，2:技能特效，3:通用特效）
#####condition：int触发条件（当type=3时 需满足使用条件  例如：魔法值需要大于100 ）
#####time: int 特效持续时间（当type=2时 需满足持续时间）单位为毫秒
#####value：int 特效数值（恢复血量/提供攻击/暴击几率等）

####创建代码示例：
    AVObject se = new AVObject("SE");
    se.put("itemId", items);
	se.put("skillId", skill);
    se.put("name", "短暂提高最大生命值");
    se.put("SE", 122);
	se.put("mode", 1);
    se.put("type", 1);
    se.put("condition", 2614);
    se.put("time", 30000);
    se.put("value", 100);
    se.saveInBackground();



##技能 Skill
#####objectId ：创建技能产生的随机ID
#####owner： String 拥有此技能的角色ID
#####name: String 技能名称
#####mode：int 技能模式 （0：无法触发 ，1：普通技能，2：持续技能，3：条件触发技能，4：自动触发）
#####type：int 技能种类 （0:无分类，1:物品技能，2:角色技能，3:未知技能）
#####condition：int触发条件（当type=3时 需满足使用条件  例如：自己生命值要大于对手生命值 ）
#####time: int 技能持续时间（当type=2时 需满足持续时间）单位为毫秒
#####UHP：int  技能消耗生命值
#####UMP: int  技能消耗魔法值

####创建代码示例：
    AVObject skill = new AVObject("Skill");
    skill.put("owner", part);
    skill.put("name", "老汉推车");
    skill.put("UHP", 122);
    skill.put("UMP", 100);
    skill.put("mode", 1);
    skill.put("type", 1);
    skill.put("condition", 2614);
    skill.put("time", 30000);
    skill.saveInBackground();


####查询代码示例：
    new AVQuery<>("Skill").whereEqualTo("owner", part)
                .findInBackground(new FindCallback<AVObject>() {
                    @Override
                    public void done(List<AVObject> list, AVException e) {
                        for (AVObject skill : list) {
                            Logger.e(e == null ? skill.getString("name") : e.getMessage());
                        }
                    }
                });




