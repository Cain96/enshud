program	SPROGRAM	17	1
testBasic	SIDENTIFIER	43	1
(	SLPAREN	33	1
input	SIDENTIFIER	43	1
,	SCOMMA	41	1
output	SIDENTIFIER	43	1
)	SRPAREN	34	1
;	SSEMICOLON	37	1
var	SVAR	21	2
i	SIDENTIFIER	43	2
:	SCOLON	38	2
integer	SINTEGER	11	2
;	SSEMICOLON	37	2
a	SIDENTIFIER	43	3
:	SCOLON	38	3
array	SARRAY	1	3
[	SLBRACKET	35	3
1	SCONSTANT	44	3
..	SRANGE	39	3
10	SCONSTANT	44	3
]	SRBRACKET	36	3
of	SOF	14	3
integer	SINTEGER	11	3
;	SSEMICOLON	37	3
msg	SIDENTIFIER	43	4
:	SCOLON	38	4
char	SCHAR	4	4
;	SSEMICOLON	37	4
debug	SIDENTIFIER	43	5
:	SCOLON	38	5
boolean	SBOOLEAN	3	5
;	SSEMICOLON	37	5
procedure	SPROCEDURE	16	7
printData	SIDENTIFIER	43	7
;	SSEMICOLON	37	7
var	SVAR	21	8
i	SIDENTIFIER	43	8
:	SCOLON	38	8
integer	SINTEGER	11	8
;	SSEMICOLON	37	8
begin	SBEGIN	2	9
i	SIDENTIFIER	43	10
:=	SASSIGN	40	10
1	SCONSTANT	44	10
;	SSEMICOLON	37	10
while	SWHILE	22	11
i	SIDENTIFIER	43	11
<=	SLESSEQUAL	27	11
10	SCONSTANT	44	11
do	SDO	6	11
begin	SBEGIN	2	12
writeln	SWRITELN	23	13
(	SLPAREN	33	13
a	SIDENTIFIER	43	13
[	SLBRACKET	35	13
i	SIDENTIFIER	43	13
]	SRBRACKET	36	13
)	SRPAREN	34	13
;	SSEMICOLON	37	13
i	SIDENTIFIER	43	14
:=	SASSIGN	40	14
i	SIDENTIFIER	43	14
+	SPLUS	30	14
1	SCONSTANT	44	14
end	SEND	8	15
end	SEND	8	16
;	SSEMICOLON	37	16
begin	SBEGIN	2	22
debug	SIDENTIFIER	43	23
:=	SASSIGN	40	23
true	STRUE	20	23
;	SSEMICOLON	37	23
msg	SIDENTIFIER	43	24
:=	SASSIGN	40	24
'D'	SSTRING	45	24
;	SSEMICOLON	37	24
writeln	SWRITELN	23	25
(	SLPAREN	33	25
'***** calculating ******'	SSTRING	45	25
)	SRPAREN	34	25
;	SSEMICOLON	37	25
i	SIDENTIFIER	43	26
:=	SASSIGN	40	26
0	SCONSTANT	44	26
;	SSEMICOLON	37	26
while	SWHILE	22	27
i	SIDENTIFIER	43	27
<	SLESS	26	27
10	SCONSTANT	44	27
do	SDO	6	27
begin	SBEGIN	2	28
i	SIDENTIFIER	43	29
:=	SASSIGN	40	29
32768	SCONSTANT	44	29
;	SSEMICOLON	37	29
i	SIDENTIFIER	43	30
:=	SASSIGN	40	30
i	SIDENTIFIER	43	30
+	SPLUS	30	30
1	SCONSTANT	44	30
;	SSEMICOLON	37	30
a	SIDENTIFIER	43	31
[	SLBRACKET	35	31
i	SIDENTIFIER	43	31
]	SRBRACKET	36	31
:=	SASSIGN	40	31
i	SIDENTIFIER	43	31
*	SSTAR	32	31
i	SIDENTIFIER	43	31
;	SSEMICOLON	37	31
begin	SBEGIN	2	32
if	SIF	10	33
debug	SIDENTIFIER	43	33
=	SEQUAL	24	33
true	STRUE	20	33
then	STHEN	19	33
begin	SBEGIN	2	33
writeln	SWRITELN	23	33
(	SLPAREN	33	33
'['	SSTRING	45	33
,	SCOMMA	41	33
msg	SIDENTIFIER	43	33
,	SCOMMA	41	33
'] i='	SSTRING	45	33
,	SCOMMA	41	33
i	SIDENTIFIER	43	33
)	SRPAREN	34	33
end	SEND	8	33
end	SEND	8	34
end	SEND	8	35
;	SSEMICOLON	37	35
writeln	SWRITELN	23	36
(	SLPAREN	33	36
'***** result ******'	SSTRING	45	36
)	SRPAREN	34	36
;	SSEMICOLON	37	36
printData	SIDENTIFIER	43	37
end	SEND	8	38
.	SDOT	42	38
