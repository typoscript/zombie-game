# 좀비 콘솔 게임

## 객체지향의 다형성을 활용한 게임

### 게임 룰

1. Hero가 왼쪽을 시작으로 오른쪽 끝까지 이동하면 승리한다. </br>
2. Hero가 이동 중에 좀비/좀비 보스와 마주치면 전투에 들어간다. </br>
3. 전투 중엔 Hero는 공격(1번) 혹은 체력 물약 사용(2번)을 선택해야한다. </br>
4. 전투는 Hero와 Hero의 적 둘 중 한명을 사망할 때까지 지속된다. </br>
5. Hero의 공격 이후 적도 Hero에게 공격을 가한다. </br>
6. Hero가 적을 쓰러트리면 계속 이동이 가능하다. </br>
7. Hero의 체력이 0이 되면 게임에서 진다. </br>
</br>

> Hero의 특성
- 공격력은 20이다. </br>
- 체력 물약 5개를 소유한다. </br>
- 체력 물약 사용 시, 체력 20이 회복된다. </br>
</br>


> 좀비의 특성
- 좀비가 Hero를 대상으로 매번 공격 시, 공격력은 1 ~ 10 중 랜덤으로 정해지며, 정해진 공격력으로 공격을 가한다. </br>
- 좀비는 공격 이후, 자신의 공격력의 절반만큼 자신의 체력을 회복한다. </br>
 </br>
 
> 보스 좀비의 특성
- 보스 좀비가 Hero를 대상으로 매번 공격 시, 공격력은 5 ~ 10 중 랜덤으로 정해지며, 80% 확률로 랜덤으로 정해진 공격력의 두배로 공격을 가한다. </br>
- 보스 좀비는 쉴드 5를 지니고 있어서 적에게 받은 피해량이 5만큼 줄어든다. </br>
</br>

### UML Class Diagram
<img src="https://github.com/typoscript/zombie-game/blob/master/images/class-diagram.jpg" />

</br>

### 데모 영상
![a](https://github.com/typoscript/zombie-game/blob/master/images/demo.gif)
