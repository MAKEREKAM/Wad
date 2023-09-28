# Wad
마인크래프트 광물 분포 플러그인

### 사용법
```
/wad [청크 반지름] [블럭의 Material 코드] [청크당 블럭 생성 시도 수] [최대 Y] [최소 Y]
```

### 광물 생성 알고리즘 이해
광물 생성은 청크(Chunk) 단위로 이루어집니다.
한 청크에서 무작위로 청크당 블럭 생성 시도 수만큼 위치를 뽑고, 
그곳이 최대 Y와 최소 Y 범위에 있으면서 돌이나 심층암이라면, 
해당 블럭이 입력한 블럭으로 대체됩니다.
