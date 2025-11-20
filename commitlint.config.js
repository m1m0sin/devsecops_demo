module.exports = {
    parserPreset: {
        parserOpts: {
            headerPattern: /^(?:(?:((?:AB#[0-9]{1,6}(?:,\s?AB#[0-9]{1,6}\s?)*))-\s?)?(feat|fix|style|build|ci|refactor|test|doc|revert)(?:\(([^)]{0,10})\))?:\s?(.{5,60}))$/,
            headerCorrespondence: [
                'tickets',
                'type',
                'scope',
                'subject'
            ]
        }
    },
    rules: {
        'type-enum': [
            2,
            'always',
            [
                'feat',
                'fix',
                'style',
                'build',
                'ci',
                'refactor',
                'test',
                'doc',
                'revert'
            ]
        ],
        'subject-min-length': [2, 'always', 5],
        'subject-max-length': [2, 'always', 60]
    }
};