program	SPROGRAM	17	1
primeFactorization	SIDENTIFIER	43	1
(	SLPAREN	33	1
output	SIDENTIFIER	43	1
)	SRPAREN	34	1
;	SSEMICOLON	37	1
var	SVAR	21	2
FACTOR	SIDENTIFIER	43	2
:	SCOLON	38	2
array	SARRAY	1	2
[	SLBRACKET	35	2
1	SCONSTANT	44	2
..	SRANGE	39	2
30	SCONSTANT	44	2
]	SRBRACKET	36	2
of	SOF	14	2
integer	SINTEGER	11	2
;	SSEMICOLON	37	2
TIMES	SIDENTIFIER	43	3
:	SCOLON	38	3
array	SARRAY	1	3
[	SLBRACKET	35	3
1	SCONSTANT	44	3
..	SRANGE	39	3
30	SCONSTANT	44	3
]	SRBRACKET	36	3
of	SOF	14	3
integer	SINTEGER	11	3
;	SSEMICOLON	37	3
DATA	SIDENTIFIER	43	4
:	SCOLON	38	4
array	SARRAY	1	4
[	SLBRACKET	35	4
1	SCONSTANT	44	4
..	SRANGE	39	4
10	SCONSTANT	44	4
]	SRBRACKET	36	4
of	SOF	14	4
integer	SINTEGER	11	4
;	SSEMICOLON	37	4
NUM	SIDENTIFIER	43	5
:	SCOLON	38	5
integer	SINTEGER	11	5
;	SSEMICOLON	37	5
i	SIDENTIFIER	43	6
,	SCOMMA	41	6
j	SIDENTIFIER	43	6
,	SCOMMA	41	6
k	SIDENTIFIER	43	6
:	SCOLON	38	6
integer	SINTEGER	11	6
;	SSEMICOLON	37	6
m	SIDENTIFIER	43	7
,	SCOMMA	41	7
n	SIDENTIFIER	43	7
:	SCOLON	38	7
integer	SINTEGER	11	7
;	SSEMICOLON	37	7
begin	SBEGIN	2	8
m	SIDENTIFIER	43	9
:=	SASSIGN	40	9
17	SCONSTANT	44	9
;	SSEMICOLON	37	9
n	SIDENTIFIER	43	10
:=	SASSIGN	40	10
23	SCONSTANT	44	10
;	SSEMICOLON	37	10
DATA	SIDENTIFIER	43	11
[	SLBRACKET	35	11
1	SCONSTANT	44	11
]	SRBRACKET	36	11
:=	SASSIGN	40	11
345	SCONSTANT	44	11
;	SSEMICOLON	37	11
i	SIDENTIFIER	43	12
:=	SASSIGN	40	12
2	SCONSTANT	44	12
;	SSEMICOLON	37	12
while	SWHILE	22	13
i	SIDENTIFIER	43	13
<=	SLESSEQUAL	27	13
10	SCONSTANT	44	13
do	SDO	6	13
begin	SBEGIN	2	14
DATA	SIDENTIFIER	43	15
[	SLBRACKET	35	15
i	SIDENTIFIER	43	15
]	SRBRACKET	36	15
:=	SASSIGN	40	15
DATA	SIDENTIFIER	43	15
[	SLBRACKET	35	15
i	SIDENTIFIER	43	15
-	SMINUS	31	15
1	SCONSTANT	44	15
]	SRBRACKET	36	15
*	SSTAR	32	15
m	SIDENTIFIER	43	15
+	SPLUS	30	15
n	SIDENTIFIER	43	15
;	SSEMICOLON	37	15
while	SWHILE	22	16
DATA	SIDENTIFIER	43	16
[	SLBRACKET	35	16
i	SIDENTIFIER	43	16
]	SRBRACKET	36	16
>	SGREAT	29	16
1000	SCONSTANT	44	16
do	SDO	6	16
DATA	SIDENTIFIER	43	17
[	SLBRACKET	35	17
i	SIDENTIFIER	43	17
]	SRBRACKET	36	17
:=	SASSIGN	40	17
DATA	SIDENTIFIER	43	17
[	SLBRACKET	35	17
i	SIDENTIFIER	43	17
]	SRBRACKET	36	17
-	SMINUS	31	17
1000	SCONSTANT	44	17
;	SSEMICOLON	37	17
i	SIDENTIFIER	43	18
:=	SASSIGN	40	18
i	SIDENTIFIER	43	18
+	SPLUS	30	18
1	SCONSTANT	44	18
end	SEND	8	19
;	SSEMICOLON	37	19
k	SIDENTIFIER	43	20
:=	SASSIGN	40	20
1	SCONSTANT	44	20
;	SSEMICOLON	37	20
while	SWHILE	22	21
k	SIDENTIFIER	43	21
<=	SLESSEQUAL	27	21
10	SCONSTANT	44	21
do	SDO	6	21
begin	SBEGIN	2	22
j	SIDENTIFIER	43	23
:=	SASSIGN	40	23
2	SCONSTANT	44	23
;	SSEMICOLON	37	23
i	SIDENTIFIER	43	24
:=	SASSIGN	40	24
0	SCONSTANT	44	24
;	SSEMICOLON	37	24
NUM	SIDENTIFIER	43	25
:=	SASSIGN	40	25
DATA	SIDENTIFIER	43	25
[	SLBRACKET	35	25
k	SIDENTIFIER	43	25
]	SRBRACKET	36	25
;	SSEMICOLON	37	25
while	SWHILE	22	26
NUM	SIDENTIFIER	43	26
<>	SNOTEQUAL	25	26
1	SCONSTANT	44	26
do	SDO	6	26
begin	SBEGIN	2	27
if	SIF	10	28
NUM	SIDENTIFIER	43	28
div	SDIVD	5	28
j	SIDENTIFIER	43	28
*	SSTAR	32	28
j	SIDENTIFIER	43	28
=	SEQUAL	24	28
NUM	SIDENTIFIER	43	28
then	STHEN	19	28
begin	SBEGIN	2	29
i	SIDENTIFIER	43	30
:=	SASSIGN	40	30
i	SIDENTIFIER	43	30
+	SPLUS	30	30
1	SCONSTANT	44	30
;	SSEMICOLON	37	30
FACTOR	SIDENTIFIER	43	31
[	SLBRACKET	35	31
i	SIDENTIFIER	43	31
]	SRBRACKET	36	31
:=	SASSIGN	40	31
j	SIDENTIFIER	43	31
;	SSEMICOLON	37	31
TIMES	SIDENTIFIER	43	32
[	SLBRACKET	35	32
i	SIDENTIFIER	43	32
]	SRBRACKET	36	32
:=	SASSIGN	40	32
1	SCONSTANT	44	32
;	SSEMICOLON	37	32
NUM	SIDENTIFIER	43	33
:=	SASSIGN	40	33
NUM	SIDENTIFIER	43	33
div	SDIVD	5	33
j	SIDENTIFIER	43	33
end	SEND	8	34
;	SSEMICOLON	37	34
while	SWHILE	22	35
NUM	SIDENTIFIER	43	35
div	SDIVD	5	35
j	SIDENTIFIER	43	35
*	SSTAR	32	35
j	SIDENTIFIER	43	35
=	SEQUAL	24	35
NUM	SIDENTIFIER	43	35
do	SDO	6	35
begin	SBEGIN	2	36
TIMES	SIDENTIFIER	43	37
[	SLBRACKET	35	37
i	SIDENTIFIER	43	37
]	SRBRACKET	36	37
:=	SASSIGN	40	37
TIMES	SIDENTIFIER	43	37
[	SLBRACKET	35	37
i	SIDENTIFIER	43	37
]	SRBRACKET	36	37
+	SPLUS	30	37
1	SCONSTANT	44	37
;	SSEMICOLON	37	37
NUM	SIDENTIFIER	43	38
:=	SASSIGN	40	38
NUM	SIDENTIFIER	43	38
div	SDIVD	5	38
j	SIDENTIFIER	43	38
end	SEND	8	39
;	SSEMICOLON	37	39
if	SIF	10	40
j	SIDENTIFIER	43	40
=	SEQUAL	24	40
2	SCONSTANT	44	40
then	STHEN	19	40
begin	SBEGIN	2	41
j	SIDENTIFIER	43	42
:=	SASSIGN	40	42
3	SCONSTANT	44	42
end	SEND	8	43
else	SELSE	7	44
begin	SBEGIN	2	45
j	SIDENTIFIER	43	46
:=	SASSIGN	40	46
j	SIDENTIFIER	43	46
+	SPLUS	30	46
2	SCONSTANT	44	46
end	SEND	8	47
end	SEND	8	48
;	SSEMICOLON	37	48
j	SIDENTIFIER	43	49
:=	SASSIGN	40	49
1	SCONSTANT	44	49
;	SSEMICOLON	37	49
writeln	SWRITELN	23	50
(	SLPAREN	33	50
' ANARISE '	SSTRING	45	50
,	SCOMMA	41	50
DATA	SIDENTIFIER	43	50
[	SLBRACKET	35	50
k	SIDENTIFIER	43	50
]	SRBRACKET	36	50
,	SCOMMA	41	50
' = '	SSTRING	45	50
)	SRPAREN	34	50
;	SSEMICOLON	37	50
while	SWHILE	22	51
j	SIDENTIFIER	43	51
<=	SLESSEQUAL	27	51
i	SIDENTIFIER	43	51
do	SDO	6	51
begin	SBEGIN	2	52
writeln	SWRITELN	23	53
(	SLPAREN	33	53
'               '	SSTRING	45	53
,	SCOMMA	41	53
FACTOR	SIDENTIFIER	43	53
[	SLBRACKET	35	53
j	SIDENTIFIER	43	53
]	SRBRACKET	36	53
,	SCOMMA	41	53
'^'	SSTRING	45	53
,	SCOMMA	41	53
TIMES	SIDENTIFIER	43	53
[	SLBRACKET	35	53
j	SIDENTIFIER	43	53
]	SRBRACKET	36	53
)	SRPAREN	34	53
;	SSEMICOLON	37	53
j	SIDENTIFIER	43	54
:=	SASSIGN	40	54
j	SIDENTIFIER	43	54
+	SPLUS	30	54
1	SCONSTANT	44	54
end	SEND	8	55
;	SSEMICOLON	37	55
k	SIDENTIFIER	43	56
:=	SASSIGN	40	56
k	SIDENTIFIER	43	56
+	SPLUS	30	56
1	SCONSTANT	44	56
end	SEND	8	57
end	SEND	8	58
.	SDOT	42	58
