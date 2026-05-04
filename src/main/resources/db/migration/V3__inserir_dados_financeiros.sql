INSERT INTO matricula(aluno_id, data_matricula, dia_vencimento, status)
VALUES (2,current_date - interval '90 days',10, 'ATIVA');

INSERT INTO matricula(aluno_id, data_matricula, dia_vencimento, status)
VALUES (3,current_date - interval '60 days',15, 'ATIVA');

INSERT INTO matricula_modalidade(matricula_id,modalidade_id,plano_id,data_inicio)
SELECT m.id,mo.id,p.id,current_date - interval '90 days'
from matricula m
    join modalidades mo on mo.nome = 'Musculação'
    join planos p on p.modalidade_id = mo.id and p.nome = 'Mensal'
where m.aluno_id = 2;

INSERT INTO matricula_modalidade(matricula_id,modalidade_id,plano_id,graduacao_id,data_inicio)
SELECT m.id,mo.id,p.id,g.id,current_date - interval '60 days'
from matricula m
    join modalidades mo on mo.nome = 'Jiu-Jitsu'
    join graduacoes g on g.modalidade_id = mo.id and g.nome = 'Faixa Branca'
    join planos p on p.modalidade_id = mo.id and p.nome = 'Mensal'
where m.aluno_id = 3;

INSERT INTO faturas_matriculas(matricula_id, data_vencimento, valor, data_pagamento, status)
SELECT m.id,current_date - interval '60 days',120.00, current_date - interval '58 days',
       'PAGA'
FROM matricula m
WHERE m.aluno_id = 2;

INSERT INTO faturas_matriculas(matricula_id, data_vencimento, valor, data_pagamento, status)
SELECT m.id,current_date - interval '30 days',120.00, current_date - interval '29 days',
    'PAGA'
FROM matricula m
WHERE m.aluno_id = 2;

INSERT INTO faturas_matriculas(matricula_id, data_vencimento, valor,status)
SELECT m.id,current_date - interval '10 days',120.00,'ABERTA'
FROM matricula m
WHERE m.aluno_id = 2;

INSERT INTO faturas_matriculas(matricula_id, data_vencimento, valor, data_pagamento, status)
SELECT m.id,current_date - interval '30 days',180.00, current_date - interval '28 days',
    'PAGA'
FROM matricula m
WHERE m.aluno_id = 3;

INSERT INTO faturas_matriculas(matricula_id, data_vencimento, valor, data_pagamento, status)
SELECT m.id,current_date - interval '28 days',180.00, current_date - interval '29 days',
    'PAGA'
FROM matricula m
WHERE m.aluno_id = 3;

INSERT INTO faturas_matriculas(matricula_id, data_vencimento, valor,status)
SELECT m.id,current_date - interval '15 days',120.00,'ABERTA'
FROM matricula m
WHERE m.aluno_id = 3;