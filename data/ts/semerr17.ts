program	SPROGRAM	17	1
fibo	SIDENTIFIER	43	1
(	SLPAREN	33	1
input	SIDENTIFIER	43	1
,	SCOMMA	41	1
output	SIDENTIFIER	43	1
)	SRPAREN	34	1
;	SSEMICOLON	37	1
var	SVAR	21	2
NN	SIDENTIFIER	43	2
:	SCOLON	38	2
integer	SINTEGER	11	2
;	SSEMICOLON	37	2
debug	SIDENTIFIER	43	3
:	SCOLON	38	3
boolean	SBOOLEAN	3	3
;	SSEMICOLON	37	3
procedure	SPROCEDURE	16	5
nacci	SIDENTIFIER	43	5
(	SLPAREN	33	5
fn1	SIDENTIFIER	43	5
,	SCOMMA	41	5
fn2	SIDENTIFIER	43	5
,	SCOMMA	41	5
n	SIDENTIFIER	43	5
:	SCOLON	38	5
integer	SINTEGER	11	5
)	SRPAREN	34	5
;	SSEMICOLON	37	5
var	SVAR	21	6
fn	SIDENTIFIER	43	6
:	SCOLON	38	6
integer	SINTEGER	11	6
;	SSEMICOLON	37	6
begin	SBEGIN	2	7
fn	SIDENTIFIER	43	8
:=	SASSIGN	40	8
fn1	SIDENTIFIER	43	8
+	SPLUS	30	8
fn2	SIDENTIFIER	43	8
;	SSEMICOLON	37	8
writeln	SWRITELN	23	9
(	SLPAREN	33	9
'F_'	SSTRING	45	9
,	SCOMMA	41	9
n	SIDENTIFIER	43	9
,	SCOMMA	41	9
' = '	SSTRING	45	9
,	SCOMMA	41	9
fn	SIDENTIFIER	43	9
)	SRPAREN	34	9
;	SSEMICOLON	37	9
if	SIF	10	10
n	SIDENTIFIER	43	10
<	SLESS	26	10
NN	SIDENTIFIER	43	10
then	STHEN	19	10
begin	SBEGIN	2	11
nacci	SIDENTIFIER	43	12
(	SLPAREN	33	12
fn	SIDENTIFIER	43	12
,	SCOMMA	41	12
fn1	SIDENTIFIER	43	12
,	SCOMMA	41	12
n	SIDENTIFIER	43	12
+	SPLUS	30	12
1	SCONSTANT	44	12
)	SRPAREN	34	12
end	SEND	8	13
end	SEND	8	14
;	SSEMICOLON	37	14
begin	SBEGIN	2	16
NN	SIDENTIFIER	43	17
:=	SASSIGN	40	17
23	SCONSTANT	44	17
;	SSEMICOLON	37	17
debug	SIDENTIFIER	43	18
:=	SASSIGN	40	18
true	STRUE	20	18
;	SSEMICOLON	37	18
writeln	SWRITELN	23	19
(	SLPAREN	33	19
'Fibonacci Numbers'	SSTRING	45	19
)	SRPAREN	34	19
;	SSEMICOLON	37	19
writeln	SWRITELN	23	20
(	SLPAREN	33	20
'F_1 = 1'	SSTRING	45	20
)	SRPAREN	34	20
;	SSEMICOLON	37	20
writeln	SWRITELN	23	21
(	SLPAREN	33	21
'F_2 = 1'	SSTRING	45	21
)	SRPAREN	34	21
;	SSEMICOLON	37	21
nacci	SIDENTIFIER	43	22
(	SLPAREN	33	22
1	SCONSTANT	44	22
,	SCOMMA	41	22
1	SCONSTANT	44	22
,	SCOMMA	41	22
3	SCONSTANT	44	22
,	SCOMMA	41	22
4	SCONSTANT	44	22
)	SRPAREN	34	22
end	SEND	8	23
.	SDOT	42	23